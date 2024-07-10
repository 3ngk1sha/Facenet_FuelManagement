package com.example.projectAPI.domain.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class DateRangeDTO {
    private LocalDate startDate;
    private LocalDate endDate;


}
