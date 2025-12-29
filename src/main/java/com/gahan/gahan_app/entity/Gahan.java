package com.gahan.gahan_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gahan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gahan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Gahan belongs to Customer
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // GOLD / SILVER
    @Enumerated(EnumType.STRING)
    private MetalType metalType;

    // Necklace, Chain, Bichhiya etc
    @Enumerated(EnumType.STRING)
    private GahanType gahanType;

    private double weightInGrams;

    private double initialRate;

    private double initialValue;
}
