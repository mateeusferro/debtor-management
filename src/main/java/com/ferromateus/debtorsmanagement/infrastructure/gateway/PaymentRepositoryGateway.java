package com.ferromateus.debtorsmanagement.infrastructure.gateway;

import com.ferromateus.debtorsmanagement.application.mapper.PaymentMapper;
import com.ferromateus.debtorsmanagement.domain.gateway.PaymentGateway;
import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.PaymentEntity;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.PaymentRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PaymentRepositoryGateway implements PaymentGateway {
    private final PaymentRepository paymentRepository;

    public PaymentRepositoryGateway(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        PaymentEntity paymentEntity = PaymentMapper.toEntity(payment);
        PaymentEntity savedPaymentEntity = paymentRepository.save(paymentEntity);
        return PaymentMapper.toDomain(savedPaymentEntity);
    }

    @Override
    public List<Payment> getPayments() {
        List<PaymentEntity> payments = (List<PaymentEntity>) paymentRepository.findAll();
        return payments.stream().map(PaymentMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Payment> getPaymentsByDebt(UUID debtId) {
        return List.of();
    }

    @Override
    public Payment getPayment(UUID id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id).orElse(null);
        return PaymentMapper.toDomain(paymentEntity);
    }

    @Override
    public Payment updatePayment(UUID id, Payment payment) {
        PaymentEntity paymentEntity = paymentRepository.findById(id).orElse(null);
        if (paymentEntity == null) throw new IllegalArgumentException("Payment not found");

        paymentEntity.setId(payment.getId());
        PaymentEntity debtToUpdate = PaymentMapper.toEntity(payment);
        PaymentEntity updatedDebt = paymentRepository.save(debtToUpdate);
        return PaymentMapper.toDomain(updatedDebt);
    }

    // To do: instead deleting on DB, just setting is active to false
    @Override
    public void deletePayment(UUID id) {
        paymentRepository.deleteById(id);
    }
}
