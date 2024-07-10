package com.example.projectAPI.service;

import com.example.projectAPI.domain.DTO.FuelDataDTO;
import com.example.projectAPI.domain.FuelData;

import com.example.projectAPI.repository.FuelDataRepository;
import com.example.projectAPI.util.MapperDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: VanDung
 * @since : 7/10/2024
 */
@Service
public class FuelService {
    private final Logger LOGGER = LogManager.getLogger(FuelService.class);
    private final FuelDataRepository fuelDataRepository;

    public FuelService(FuelDataRepository fuelDataRepository) {
        this.fuelDataRepository = fuelDataRepository;

    }

    //This code is list all data fuel
    public List<FuelData> listFuelData() {
        List<FuelData> fuelDataList = this.fuelDataRepository.findAll();
        return fuelDataList;
    }

    //This code is get Fuel Data by date range
    public Map<Integer,List<FuelDataDTO>> getFuelDataByDateRange(LocalDate startTime, LocalDate endTime) {
        List<FuelData> fuels = this.fuelDataRepository.findFuelDataBetweenDates(startTime,endTime);
        if(fuels.isEmpty()) {
            LOGGER.info("query: no fuels data");
            return new HashMap<>();
        }
        LOGGER.info("query: fuels data");

        List<FuelDataDTO> fuelDataDTOs = new ArrayList<>();
        FuelDataDTO fuelDataDTO = new FuelDataDTO();
        for(FuelData fuelData : fuels) {
            fuelDataDTO = MapperDTO.setFuelDataDTO(fuelData);
            fuelDataDTOs.add(fuelDataDTO);

        }
        LOGGER.info("get fuels data");

        fuels = null;
        fuelDataDTO = null;

        return fuelDataDTOs.stream()
                .collect(Collectors.groupingBy(FuelDataDTO::getFuelType));
    }

    //This code is statisticFuel by input array
    public List<FuelDataDTO> statisticFuel(int key,int value){
        List<FuelDataDTO> fuelDataArrayList = new ArrayList<>();
        List<FuelData> fuelDataList = this.fuelDataRepository.findFuelDataByFuelNameId(key);
        if(fuelDataList.isEmpty()) {
            LOGGER.info("query: no fuels data");
            return new ArrayList<>();
        }
        LOGGER.info("query: fuels data");

        FuelDataDTO fuelDataDTO = new FuelDataDTO();
        for(FuelData fuelData : fuelDataList) {
            if(value >= fuelData.getQuantity()) {
                value -= fuelData.getQuantity();
                fuelDataDTO = MapperDTO.setFuelDataDTO(fuelData);
                fuelDataArrayList.add(fuelDataDTO);
            }
        }
        LOGGER.info("get fuels data");

        fuelDataList = null;
        fuelDataDTO = null;

        return fuelDataArrayList;
    }


}
