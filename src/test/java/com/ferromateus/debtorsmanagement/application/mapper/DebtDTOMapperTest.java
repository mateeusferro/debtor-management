package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtDTO;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtorDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DebtDTOMapperTest {

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

    private final UUID debtorId = UUID.randomUUID();
    private final DebtDTO mockedDebtDTO = new DebtDTO(
            BigDecimal.valueOf(500),
            "I lent $500",
            LocalDate.of(2025, 1, 31),
            "OPEN",
            debtorId
    );
    private final Debt mockedDebt = new Debt(
            null,
            BigDecimal.valueOf(500),
            null,
            "I lent $500",
            null,
            LocalDate.of(2025, 1, 31),
            "OPEN"
    );

    @Test
    void toDomain() {
        Debt debt = DebtDTOMapper.toDomain(mockedDebtDTO);
        assertEquals(debt, mockedDebt);
    }

    @Test
    void toDomain_NullDebtDTO() {
        assertThrows(IllegalArgumentException.class, () -> DebtDTOMapper.toDomain(null));
    }
}