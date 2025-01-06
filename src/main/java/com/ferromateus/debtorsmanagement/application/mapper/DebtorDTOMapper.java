package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtorDTO;

public class DebtorDTOMapper {

    private DebtorDTOMapper() {}

    public static Debtor toDomain(DebtorDTO debtorDTO) {
        if (debtorDTO == null) throw new IllegalArgumentException("The debtorDTO cannot be null");
        return new Debtor(
                null,
                debtorDTO.address(),
                debtorDTO.cpf(),
                debtorDTO.email(),
                debtorDTO.name(),
                debtorDTO.phoneNumber(),
                null
        );
    }
}
