package com.gahan.gahan_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Gahan gahan;

    private double principalAmount;

    private double interestRate; // 2%

    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;
}
