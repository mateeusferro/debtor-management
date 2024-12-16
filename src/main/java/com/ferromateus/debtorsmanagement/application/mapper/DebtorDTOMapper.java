package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtorDTO;

public class DebtorDTOMapper {

    // Will we need?
//    public static debtorDTO toDTO(Debtor debtor) {}

    public static Debtor toDomain(DebtorDTO debtorDTO) {
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
