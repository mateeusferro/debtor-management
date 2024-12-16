package com.ferromateus.debtorsmanagement.presentation.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record DebtDTO(BigDecimal amount, String description, LocalDate dueDate, String status, UUID debtorId) {
}
