package com.ferromateus.debtorsmanagement.presentation.controller;

import com.ferromateus.debtorsmanagement.application.mapper.PaymentDTOMapper;
import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.CreatePaymentUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.GetPaymentByIdUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.GetPaymentsUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.presentation.dto.PaymentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    CreatePaymentUseCase createPaymentUseCase;
    GetPaymentByIdUseCase getPaymentByIdUseCase;
    GetPaymentsUseCase getPaymentsUseCase;

    public PaymentController(CreatePaymentUseCase createPaymentUseCase,
                             GetPaymentByIdUseCase getPaymentByIdUseCase,
                             GetPaymentsUseCase getPaymentsUseCase) {
        this.createPaymentUseCase = createPaymentUseCase;
        this.getPaymentByIdUseCase = getPaymentByIdUseCase;
        this.getPaymentsUseCase = getPaymentsUseCase;
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = createPaymentUseCase.execute(PaymentDTOMapper.toDomain(paymentDTO), paymentDTO.debtId());
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    @GetMapping("{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable UUID id) {
        Payment payment = getPaymentByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments() {
        List<Payment> payments = getPaymentsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(payments);
    }
}
