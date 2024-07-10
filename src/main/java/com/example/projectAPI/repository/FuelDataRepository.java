package com.example.projectAPI.repository;

import com.example.projectAPI.domain.FuelData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface FuelDataRepository extends JpaRepository<FuelData, Integer> {
    //This query is query date between startDate and enDate
    @Query("SELECT o FROM FuelData o WHERE o.date BETWEEN :startDate AND :endDate")
    List<FuelData> findFuelDataBetweenDates(LocalDate startDate, LocalDate endDate);

    //This query is query data where = id and sort desc
    @Query("SELECT o FROM FuelData o WHERE o.fuelName.id = :fuelNameId order by o.date desc ")
    List<FuelData> findFuelDataByFuelNameId(int fuelNameId);



}
