package com.ferromateus.debtorsmanagement.presentation.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDTO(BigDecimal amount, String method, UUID debtId) {
}
