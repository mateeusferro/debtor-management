package com.ferromateus.debtorsmanagement.application.usecase.payment.impl;

import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.CreatePaymentUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtGateway;
import com.ferromateus.debtorsmanagement.domain.gateway.PaymentGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;
    private final DebtGateway debtGateway;

    public CreatePaymentUseCaseImpl(PaymentGateway paymentGateway, DebtGateway debtGateway) {
        this.paymentGateway = paymentGateway;
        this.debtGateway = debtGateway;
    }

    @Override
    public Payment execute(Payment payment, UUID debtId) {
        Debt debt = debtGateway.getDebt(debtId);
        payment.setDebt(debt);
        payment.setPaymentDate(LocalDateTime.now());
        return paymentGateway.createPayment(payment);
    }
}
