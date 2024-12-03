package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtorEntity;

public class DebtorMapper {
    public static Debtor toDomain(DebtorEntity debtor) {
        return new Debtor(
                debtor.getId(),
                debtor.getAddress(),
                debtor.getCpf(),
                debtor.getEmail(),
                debtor.getName(),
                debtor.getPhoneNumber(),
                debtor.getStatus()
        );
    }

    public static DebtorEntity toEntity(Debtor debtor) {
        return new DebtorEntity(
                debtor.getId(),
                debtor.getCpf(),
                debtor.getEmail(),
                debtor.getName(),
                debtor.getAddress(),
                debtor.getStatus(),
                debtor.getPhoneNumber()
        );
    }
}
