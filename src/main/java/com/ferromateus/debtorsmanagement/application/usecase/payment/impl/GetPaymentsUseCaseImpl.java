package com.ferromateus.debtorsmanagement.application.usecase.payment.impl;

import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.GetPaymentsUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.PaymentGateway;
import com.ferromateus.debtorsmanagement.domain.model.Payment;

import java.util.List;

public class GetPaymentsUseCaseImpl implements GetPaymentsUseCase {

    private final PaymentGateway paymentGateway;

    public GetPaymentsUseCaseImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public List<Payment> execute() {
        return paymentGateway.getPayments();
    }
}
