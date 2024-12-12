package com.ferromateus.debtorsmanagement.domain.gateway;

import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentGateway {
    Payment createPayment(Payment payment);
    List<Payment> getPayments();

    // In future
//    List<Payment> getPayments(int size, int offset);
    List<Payment> getPaymentsByDebt(UUID debtId);
    Payment getPayment(UUID id);
    Payment updatePayment(UUID id, Payment payment);
    void deletePayment(UUID id);
}