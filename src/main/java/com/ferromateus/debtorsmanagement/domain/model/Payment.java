package com.ferromateus.debtorsmanagement.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private UUID id;
    private BigDecimal amount;
    private Debt debt;
    private LocalDateTime paymentDate;
    private String method;

    public Payment() {}

    public Payment(UUID id, BigDecimal amount, Debt debt, LocalDateTime paymentDate, String method) {
        this.id = id;
        this.amount = amount;
        this.debt = debt;
        this.paymentDate = paymentDate;
        this.method = method;
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

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
