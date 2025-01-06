package com.ferromateus.debtorsmanagement.application.usecase.payment.impl;

import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.CreatePaymentUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.GetPaymentByIdUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtorRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.PaymentRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtRepository;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtorRepository;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class GetPaymentByIdUseCaseImplTest {

    @Autowired
    private DebtRepository debtRepository;
    @Autowired
    private DebtorRepository debtorRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    private GetPaymentByIdUseCase getPaymentByIdUseCase;
    private Payment payment;
    private Debt debt;

    @BeforeEach
    void setUp() {
        DebtorRepositoryGateway debtorRepositoryGateway = new DebtorRepositoryGateway(debtorRepository);
        DebtRepositoryGateway debtRepositoryGateway = new DebtRepositoryGateway(debtRepository);
        PaymentRepositoryGateway paymentRepositoryGateway = new PaymentRepositoryGateway(paymentRepository);
        getPaymentByIdUseCase = new GetPaymentByIdUseCaseImpl(paymentRepositoryGateway);

        Debtor debtor = new Debtor(null, "Address Test", "123.456.789-10", "test@test.com",
                "Test", "12345-7891", true);
        Debtor savedDebtor = debtorRepositoryGateway.createDebtor(debtor);
        debtor.setId(savedDebtor.getId());

        debt = new Debt(null, BigDecimal.valueOf(1000.55), LocalDateTime.of(2024, 10, 30, 12, 50, 55),
                "Test Debt", savedDebtor, LocalDate.of(2025, 1, 30), "Open");
        Debt savedDebt = debtRepositoryGateway.createDebt(debt);
        debt.setId(savedDebt.getId());

        payment = new Payment(null, BigDecimal.valueOf(500.55), debt,
                LocalDateTime.of(2024, 11, 30, 12, 50, 55), "Cash");

        payment = paymentRepositoryGateway.createPayment(payment);
    }

    @Test
    void execute() {
        Payment getPayment = getPaymentByIdUseCase.execute(payment.getId());

        assertEquals(payment.getId(), getPayment.getId());
        assertEquals(payment.getAmount(), getPayment.getAmount());
        assertEquals(payment.getDebt(), getPayment.getDebt());
        assertEquals(payment.getPaymentDate(), getPayment.getPaymentDate());
        assertEquals(payment.getMethod(), getPayment.getMethod());
    }
}