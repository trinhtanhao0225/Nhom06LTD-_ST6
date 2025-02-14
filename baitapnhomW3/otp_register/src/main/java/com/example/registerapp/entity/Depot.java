package com.example.registerapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private String size;
    private String color;
    private BigDecimal price;
    private int quantity;
    private LocalDate importDate;
    @OneToMany(mappedBy = "depot")
    @ToString.Exclude
    private List<SaleHistory> saleHistories;

}
