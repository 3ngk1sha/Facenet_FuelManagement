package com.example.projectAPI.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class FuelData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private long price;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING )
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="fuelname_id")
    private FuelName fuelName;



    @Override
    public String toString() {
        return "FuelData{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", date=" + date +
                ", fuelName=" + fuelName +
                '}';
    }
}
