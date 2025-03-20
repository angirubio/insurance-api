package com.example.insurance.company.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.insurance.company.validation.ValidDateRange;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ValidDateRange
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String policyNumber;
    
    @NotNull
    private String cusomerName;
    
    @NotNull
    private LocalDate startDate;
    
    @NotNull
    private LocalDate endDate;
    
    @NotNull
    private BigDecimal premiumAmount;

}
