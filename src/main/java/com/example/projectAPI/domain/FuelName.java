package com.example.projectAPI.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class FuelName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fuelName;

    @OneToMany(mappedBy = "fuelName")
    List<FuelData> fuelDataList;




}
