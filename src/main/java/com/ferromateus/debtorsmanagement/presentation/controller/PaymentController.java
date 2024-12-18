package com.ferromateus.debtorsmanagement.presentation.controller;

import com.ferromateus.debtorsmanagement.application.mapper.PaymentDTOMapper;
import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.CreatePaymentUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Payment;
import com.ferromateus.debtorsmanagement.presentation.dto.PaymentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    CreatePaymentUseCase createPaymentUseCase;

    public PaymentController(CreatePaymentUseCase createPaymentUseCase) {
        this.createPaymentUseCase = createPaymentUseCase;
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = createPaymentUseCase.execute(PaymentDTOMapper.toDomain(paymentDTO), paymentDTO.debtId());
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
