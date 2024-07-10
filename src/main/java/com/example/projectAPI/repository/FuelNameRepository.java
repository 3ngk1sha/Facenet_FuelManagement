package com.example.projectAPI.repository;

import com.example.projectAPI.domain.FuelName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelNameRepository extends JpaRepository<FuelName, Integer> {
}
