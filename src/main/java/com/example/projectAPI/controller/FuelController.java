package com.example.projectAPI.controller;

import com.example.projectAPI.domain.DTO.DateRangeDTO;
import com.example.projectAPI.domain.DTO.FuelDataDTO;
import com.example.projectAPI.service.FuelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FuelController {

    private final Logger LOGGER = LogManager.getLogger(FuelController.class);
    private final FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @GetMapping("/fuels")
    public ResponseEntity<Map<Integer,List<FuelDataDTO>>>getFuelsBetweenDate(
            @RequestBody DateRangeDTO dateRangeDTO
            ) {
        Map<Integer,List<FuelDataDTO>> fuels = this.fuelService.getFuelDataByDateRange(dateRangeDTO.getStartDate(), dateRangeDTO.getEndDate());
        if(fuels.isEmpty()) {
            LOGGER.error("No fuels found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        LOGGER.info("Fuels found");
        return ResponseEntity.status(HttpStatus.OK).body(fuels);
    }


    @GetMapping("/statistics")
    public ResponseEntity<Map<Integer, List<FuelDataDTO>>> statisticFuels(
            @RequestBody Map<Integer, Integer> arraysFuelDTO) {
        Map<Integer, List<FuelDataDTO>> fuels = new HashMap<>();
        List<FuelDataDTO> fuelData = null;
        Integer k = null;
        Integer v = null;
        for (Map.Entry<Integer, Integer> entry : arraysFuelDTO.entrySet()) {
            k = entry.getKey();
            v = entry.getValue();
            fuelData = this.fuelService.statisticFuel(k, v);
            fuels.put(k, fuelData);
        }

        LOGGER.info("statistics: done");

        fuelData=null;
        k=null;
        v=null;

        return ResponseEntity.status(HttpStatus.OK).body(fuels);
    }

}
