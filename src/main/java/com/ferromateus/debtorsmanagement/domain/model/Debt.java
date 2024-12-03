package com.ferromateus.debtorsmanagement.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Debt {
    private UUID id;
    private BigDecimal amount;
    private LocalDateTime createdDate;
    private Debtor debtor;
    private String description;
    private LocalDate dueDate;
    private String status;

    public Debt() {}

    public Debt(UUID id, BigDecimal amount, LocalDateTime createdDate,
                String description, Debtor debtor, LocalDate dueDate, String status) {
        this.id = id;
        this.amount = amount;
        this.createdDate = createdDate;
        this.description = description;
        this.debtor = debtor;
        this.dueDate = dueDate;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public void setDebtor(Debtor debtor) {
        this.debtor = debtor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
