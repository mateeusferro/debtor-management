package com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Payment;

import java.util.UUID;

public interface GetPaymentByIdUseCase {
    Payment execute(UUID uuid);
}
