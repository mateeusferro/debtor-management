package com.ferromateus.debtorsmanagement.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DEBTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebtEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "DEBT_ID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "DEBTOR_ID", nullable = false)
    private DebtorEntity debtor;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "STATUS")
    private String status;
}
