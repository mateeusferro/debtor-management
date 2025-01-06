package com.ferromateus.debtorsmanagement.application.usecase.payment.impl;

import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.GetPaymentByIdUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.PaymentGateway;
import com.ferromateus.debtorsmanagement.domain.model.Payment;

import java.util.UUID;

public class GetPaymentByIdUseCaseImpl implements GetPaymentByIdUseCase {

    private final PaymentGateway paymentGateway;

    public GetPaymentByIdUseCaseImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public Payment execute(UUID uuid) {
        return paymentGateway.getPayment(uuid);
    }
}
