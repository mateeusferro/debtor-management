package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtorEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DebtorMapperTest {
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

    @Test
    void toDomain() {
        Debtor mappedDebtor = DebtorMapper.toDomain(mockedDebtorEntity);
        assertEquals(mappedDebtor, mockedDebtor);
    }

    @Test
    void toEntity() {
        DebtorEntity mappedDebtorEntity = DebtorMapper.toEntity(mockedDebtor);
        assertEquals(mappedDebtorEntity, mockedDebtorEntity);
    }

    @Test
    void toDomain_NullEntity() {
        assertThrows(IllegalArgumentException.class, () -> DebtorMapper.toDomain(null));
    }

    @Test
    void toEntity_NullDebtor() {
        assertThrows(IllegalArgumentException.class, () -> DebtorMapper.toEntity(null));
    }
}