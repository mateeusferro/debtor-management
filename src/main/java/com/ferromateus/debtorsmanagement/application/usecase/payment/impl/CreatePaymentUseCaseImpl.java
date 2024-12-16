package com.ferromateus.debtorsmanagement.application.usecase.payment.impl;

import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.CreatePaymentUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.PaymentGateway;
import com.ferromateus.debtorsmanagement.domain.model.Payment;

public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public CreatePaymentUseCaseImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public Payment execute(Payment payment) {
        return null;
    }
}
