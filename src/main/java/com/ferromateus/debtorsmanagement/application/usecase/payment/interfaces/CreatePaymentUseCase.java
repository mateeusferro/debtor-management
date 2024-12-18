package com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Payment;

import java.util.UUID;

public interface CreatePaymentUseCase {
    Payment execute(Payment payment, UUID debtId);
}
