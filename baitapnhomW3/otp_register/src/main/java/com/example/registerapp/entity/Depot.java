package com.example.registerapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String image;
    private String description;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @JsonBackReference
    private Type type;
    
    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    @JsonBackReference
    private Size size;
    
    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    @JsonBackReference
    private Color color;

    private BigDecimal price;
    private int quantity;
    private double discount;
    private LocalDate importDate;


}
