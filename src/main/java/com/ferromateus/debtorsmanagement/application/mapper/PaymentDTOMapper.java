package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.presentation.dto.PaymentDTO;

public class PaymentDTOMapper {

    private PaymentDTOMapper() {}

    public static Payment toDomain(PaymentDTO paymentDTO) {
        if (paymentDTO == null) throw new IllegalArgumentException("PaymentDTO cannot be null");
        return new Payment(
                null,
                paymentDTO.amount(),
                null,
                null,
                paymentDTO.method()
        );
    }
}
