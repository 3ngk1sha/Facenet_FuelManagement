package com.example.projectAPI.util;

import com.example.projectAPI.domain.DTO.FuelDataDTO;
import com.example.projectAPI.domain.FuelData;

public class MapperDTO {
    public static FuelDataDTO setFuelDataDTO(FuelData fuelData){
        FuelDataDTO fuelDataDTO = new FuelDataDTO();
        fuelDataDTO.setId(fuelData.getId());
        fuelDataDTO.setFuelType(fuelData.getFuelName().getId());
        fuelDataDTO.setQuantity(fuelData.getQuantity());
        fuelDataDTO.setPrice(fuelData.getPrice());
        fuelDataDTO.setDate(fuelData.getDate());
        return fuelDataDTO;
    }
}
