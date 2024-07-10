package com.example.projectAPI.domain.DTO;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DateRangeDTO {
    @NotNull(message = "startDate is not blank")
    private LocalDate startDate;
    @NotNull
            (message = "endDate is not blank")
    private LocalDate endDate;

    @AssertFalse(message = "startDate is not larger than endDate")
    public boolean isDateValid(){
        return startDate.isAfter(endDate);
    }


}
