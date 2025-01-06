package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtEntity;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtorEntity;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.PaymentEntity;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtDTO;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtorDTO;
import com.ferromateus.debtorsmanagement.presentation.dto.PaymentDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PaymentDTOMapperTest {
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

    private final UUID debtId = UUID.randomUUID();
    private final PaymentDTO mockedPaymentDTO = new PaymentDTO(
            BigDecimal.valueOf(250),
            "Credit Card",
            debtId
    );
    private final Payment mockedPayment = new Payment(
            null,
            BigDecimal.valueOf(250),
            null,
            null,
            "Credit Card"
    );

    @Test
    void toDomain() {
        Payment payment = PaymentDTOMapper.toDomain(mockedPaymentDTO);
        assertEquals(payment, mockedPayment);
    }

    @Test
    void toDomain_NullPaymentDTO() {
        assertThrows(IllegalArgumentException.class, () -> PaymentDTOMapper.toDomain(null));
    }
}