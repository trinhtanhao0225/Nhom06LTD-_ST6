package com.example.registerapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
public class SaleHistoryDetail {

    @EmbeddedId
    private SaleHistoryDetailKey id;

    private int quantitySold;
    private int price;

    @ManyToOne
    @MapsId("sizeId") // Để ánh xạ với khóa chính tổng hợp
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @MapsId("colorId")
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @MapsId("depotId")
    @JoinColumn(name = "depot_id")
    private Depot depot;

    @ManyToOne
    @MapsId("saleHistoryId")
    @JoinColumn(name = "sale_history_id")
    private SaleHistory saleHistory;
}
