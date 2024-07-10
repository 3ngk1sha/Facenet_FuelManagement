package com.example.projectAPI.domain.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FuelDatasDTO {
    private Integer id;
    private List<FuelDataDTO> fuelDataDTO;
}
