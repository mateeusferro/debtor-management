package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtEntity;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtorEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DebtMapperTest {
    private final UUID debtorId = UUID.randomUUID();
    private final Debtor mockedDebtor = new Debtor(
            debtorId,
            "1st Avenue, NYC",
            "123456789",
            "sample@email.com",
            "Sample name",
            "+123456789",
            true
    );
    private final DebtorEntity mockedDebtorEntity = new DebtorEntity(
            debtorId,
            "123456789",
            "sample@email.com",
            "Sample name",
            "1st Avenue, NYC",
            true,
            "+123456789"
    );

    private final UUID debtId = UUID.randomUUID();
    private final LocalDateTime dateTime = LocalDateTime.now();
    private final Debt mockedDebt = new Debt(
            debtId,
            BigDecimal.valueOf(500),
            dateTime,
            "I lent $500",
            mockedDebtor,
            LocalDate.of(2025, 1, 31),
            "OPEN"
    );
    private final DebtEntity mockedDebtEntity = new DebtEntity(
            debtId,
            mockedDebtorEntity,
            "I lent $500",
            BigDecimal.valueOf(500),
            dateTime,
            LocalDate.of(2025, 1, 31),
            "OPEN"
    );

    @Test
    void toDomain() {
        Debt mappedDebt = DebtMapper.toDomain(mockedDebtEntity);
        assertEquals(mappedDebt, mockedDebt);
    }

    @Test
    void toEntity() {
        DebtEntity mappedDebtEntity = DebtMapper.toEntity(mockedDebt);
        assertEquals(mappedDebtEntity, mockedDebtEntity);
    }

    @Test
    void toDomain_NullEntity() {
        assertThrows(IllegalArgumentException.class, () -> DebtMapper.toDomain(null));
    }

    @Test
    void toEntity_NullDebtor() {
        assertThrows(IllegalArgumentException.class, () -> DebtMapper.toEntity(null));
    }
}