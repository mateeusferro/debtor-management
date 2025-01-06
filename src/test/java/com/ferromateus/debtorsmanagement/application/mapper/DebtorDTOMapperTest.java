package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtorDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebtorDTOMapperTest {
    private final DebtorDTO mockedDebtorDTO = new DebtorDTO(
            "1st Avenue, NYC",
            "123456789",
            "sample@email.com",
            "Sample name",
            "+123456789"
    );

    private final Debtor mockedDebtor = new Debtor(
            null,
            "1st Avenue, NYC",
            "123456789",
            "sample@email.com",
            "Sample name",
            "+123456789",
            null
    );

    @Test
    void toDomain() {
        Debtor debtor = DebtorDTOMapper.toDomain(mockedDebtorDTO);
        assertEquals(debtor, mockedDebtor);
    }

    @Test
    void toDomain_NullDebtorDTO() {
        assertThrows(IllegalArgumentException.class, () -> DebtorDTOMapper.toDomain(null));
    }
}