package com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Payment;

public interface CreatePaymentUseCase {
    Payment execute(Payment payment);
}
