package com.ferromateus.debtorsmanagement.infrastructure.gateway;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.domain.model.Payment;
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
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PaymentRepositoryGatewayTest {

    @Autowired
    private DebtRepository debtRepository;
    @Autowired
    private DebtorRepository debtorRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    private PaymentRepositoryGateway paymentRepositoryGateway;
    private Payment payment;
    private UUID paymentId;
    private Debtor debtor;
    private Debt debt;

    @BeforeEach
    void setUp() {
        DebtorRepositoryGateway debtorRepositoryGateway = new DebtorRepositoryGateway(debtorRepository);
        DebtRepositoryGateway debtRepositoryGateway = new DebtRepositoryGateway(debtRepository);
        debtor = new Debtor(null, "Address Test", "123.456.789-10", "test@test.com",
                "Test", "12345-7891", true);
        Debtor savedDebtor = debtorRepositoryGateway.createDebtor(debtor);
        debtor.setId(savedDebtor.getId());

        debt = new Debt(null, BigDecimal.valueOf(1000), LocalDateTime.of(2024, 10, 30, 12, 50, 55),
                "Test Debt", savedDebtor, LocalDate.of(2025, 1, 30), "Open");
        Debt savedDebt = debtRepositoryGateway.createDebt(debt);
        debt.setId(savedDebt.getId());

        paymentRepositoryGateway = new PaymentRepositoryGateway(paymentRepository);
        payment = new Payment(null, BigDecimal.valueOf(500), debt,
                LocalDateTime.of(2024, 11, 30, 12, 50, 55), "Cash");

        Payment savedPayment = paymentRepositoryGateway.createPayment(payment);
        paymentId = savedPayment.getId();
    }

    @Test
    void createPayment() {
        Payment savedPayment = paymentRepositoryGateway.createPayment(payment);

        assertNotNull(savedPayment.getId());
        assertEquals(savedPayment.getPaymentDate(), payment.getPaymentDate());
        assertEquals(savedPayment.getAmount(), payment.getAmount());
        assertEquals(savedPayment.getDebt(), payment.getDebt());
        assertEquals(savedPayment.getMethod(), payment.getMethod());
    }

    @Test
    void getPayments() {
        List<Payment> payments = paymentRepositoryGateway.getPayments();

        assertThat(payments.size()).isNotZero();
    }

    @Test
    void getPaymentsByDebt() {
    }

    @Test
    void getPayment() {
        Payment payment = paymentRepositoryGateway.getPayment(paymentId);
        assertNotNull(payment);
    }

    @Test
    void updatePayment() {
        Payment paymentToUpdate = new Payment(null, BigDecimal.valueOf(600), debt,
                LocalDateTime.of(2024, 11, 30, 12, 50, 55), "Credit Card");
        Payment updatedPayment = paymentRepositoryGateway.updatePayment(paymentId, paymentToUpdate);

        assertNotNull(updatedPayment.getId());
        assertEquals(updatedPayment.getPaymentDate(), paymentToUpdate.getPaymentDate());
        assertEquals(updatedPayment.getAmount(), paymentToUpdate.getAmount());
        assertEquals(updatedPayment.getDebt(), paymentToUpdate.getDebt());
        assertEquals(updatedPayment.getMethod(), paymentToUpdate.getMethod());
    }

    @Test
    void deletePayment() {
        paymentRepositoryGateway.deletePayment(paymentId);
        assertThrows(IllegalArgumentException.class, () -> {
            paymentRepositoryGateway.getPayment(paymentId);
        });
    }
}