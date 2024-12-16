package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.presentation.dto.PaymentDTO;

public class PaymentDTOMapper {

    // Will we need?
//    public static paymentDTO toDTO(Payment payment) {}

    public static Payment toDomain(PaymentDTO paymentDTO) {
        return new Payment(
                null,
                paymentDTO.amount(),
                null,
                null,
                paymentDTO.method()
        );
    }
}
