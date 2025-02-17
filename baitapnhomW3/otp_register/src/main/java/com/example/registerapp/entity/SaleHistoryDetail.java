package com.example.registerapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SaleHistoryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantitySold;
    private int price;
    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Size size;
    
    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    private Color color;
    
}
