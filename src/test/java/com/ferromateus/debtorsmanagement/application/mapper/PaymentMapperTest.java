package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtEntity;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtorEntity;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.PaymentEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMapperTest {
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
    private final LocalDateTime debtDateTime = LocalDateTime.of(2024, 10, 30, 10, 20, 50);
    private final Debt mockedDebt = new Debt(
            debtId,
            BigDecimal.valueOf(500),
            debtDateTime,
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
            debtDateTime,
            LocalDate.of(2025, 1, 31),
            "OPEN"
    );

    private final UUID paymentId = UUID.randomUUID();
    private final LocalDateTime paymentDateTime = LocalDateTime.now();
    private final Payment mockedPayment = new Payment(
            paymentId,
            BigDecimal.valueOf(250),
            mockedDebt,
            paymentDateTime,
            "Credit Card"
    );
    private final PaymentEntity mockedPaymentEntity = new PaymentEntity(
            paymentId,
            mockedDebtEntity,
            BigDecimal.valueOf(250),
            paymentDateTime,
            "Credit Card"
    );

    @Test
    void toDomain() {
        Payment mappedPayment = PaymentMapper.toDomain(mockedPaymentEntity);
        assertEquals(mappedPayment, mockedPayment);
    }

    @Test
    void toEntity() {
        PaymentEntity mappedPaymentEntity = PaymentMapper.toEntity(mockedPayment);
        assertEquals(mappedPaymentEntity, mockedPaymentEntity);
    }

    @Test
    void toDomain_NullEntity() {
        assertThrows(IllegalArgumentException.class, () -> PaymentMapper.toDomain(null));
    }

    @Test
    void toEntity_NullDebtor() {
        assertThrows(IllegalArgumentException.class, () -> PaymentMapper.toEntity(null));
    }
}