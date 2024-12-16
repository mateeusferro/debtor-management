package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtDTO;

public class DebtDTOMapper {

    // Will we need?
//    public static DebtDTO toDTO(Debt debt) {}

    public static Debt toDomain(DebtDTO debtDTO) {
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
