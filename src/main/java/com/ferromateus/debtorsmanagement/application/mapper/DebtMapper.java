package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtEntity;

public class DebtMapper {

    private DebtMapper() {}

    public static Debt toDomain(DebtEntity debt) {
        if (debt == null) throw new IllegalArgumentException("Debt cannot be null");
        return new Debt(
                debt.getId(),
                debt.getAmount(),
                debt.getCreatedDate(),
                debt.getDescription(),
                DebtorMapper.toDomain(debt.getDebtor()),
                debt.getDueDate(),
                debt.getStatus()
        );
    }

    public static DebtEntity toEntity(Debt debt) {
        if (debt == null) throw new IllegalArgumentException("Debt cannot be null");
        return new DebtEntity(
                debt.getId(),
                DebtorMapper.toEntity(debt.getDebtor()),
                debt.getDescription(),
                debt.getAmount(),
                debt.getCreatedDate(),
                debt.getDueDate(),
                debt.getStatus()
        );
    }
}
