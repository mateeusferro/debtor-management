package com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Payment;

import java.util.List;

public interface GetPaymentsUseCase {
    List<Payment> execute();
}
