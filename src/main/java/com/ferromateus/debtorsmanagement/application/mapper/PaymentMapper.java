package com.ferromateus.debtorsmanagement.application.mapper;

import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.PaymentEntity;

public class PaymentMapper {
    public static Payment toDomain(PaymentEntity payment) {
        if (payment == null) throw new IllegalArgumentException("Payment cannot be null");
        return new Payment(
                payment.getId(),
                payment.getAmount(),
                DebtMapper.toDomain(payment.getDebt()),
                payment.getPaymentDate(),
                payment.getMethod()
        );
    }

    public static PaymentEntity toEntity(Payment payment) {
        if (payment == null) throw new IllegalArgumentException("Payment cannot be null");
        return new PaymentEntity(
                payment.getId(),
                DebtMapper.toEntity(payment.getDebt()),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getMethod()
        );
    }
}
