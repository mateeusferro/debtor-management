package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtDTO;

public class DebtDTOMapper {

    private DebtDTOMapper() {}

    public static Debt toDomain(DebtDTO debtDTO) {
        if (debtDTO == null) throw new IllegalArgumentException("DebtDTO cannot be null");
        return new Debt(
                null,
                debtDTO.amount(),
                null,
                debtDTO.description(),
                null,
                debtDTO.dueDate(),
                debtDTO.status()
        );
    }
}
