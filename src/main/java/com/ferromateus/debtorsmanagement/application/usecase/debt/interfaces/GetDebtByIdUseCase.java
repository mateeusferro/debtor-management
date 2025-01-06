package com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Debt;

import java.util.UUID;

public interface GetDebtByIdUseCase {
    Debt execute(UUID id);
}
