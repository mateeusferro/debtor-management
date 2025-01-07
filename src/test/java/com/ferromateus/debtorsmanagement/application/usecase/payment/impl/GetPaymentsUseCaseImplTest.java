package com.ferromateus.debtorsmanagement.application.usecase.payment.impl;

import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.GetPaymentsUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtorRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.PaymentRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class GetPaymentsUseCaseImplTest {

    @Autowired
    private PaymentRepository paymentRepository;
    private GetPaymentsUseCase getPaymentsUseCase;

    @BeforeEach
    void setUp() {
        PaymentRepositoryGateway paymentRepositoryGateway = new PaymentRepositoryGateway(paymentRepository);
        getPaymentsUseCase = new GetPaymentsUseCaseImpl(paymentRepositoryGateway);
    }

    @Test
    void execute() {
        List<Payment> payments = getPaymentsUseCase.execute();
        assertFalse(payments.isEmpty());
    }
}