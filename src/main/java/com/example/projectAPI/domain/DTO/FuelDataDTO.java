package com.example.projectAPI.domain.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class FuelDataDTO {
    private int id;

    private int quantity;
    private long price;
    private LocalDate date;
    private int fuelType;


}
