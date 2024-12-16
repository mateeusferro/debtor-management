package com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Debt;

public interface CreateDebtUseCase {
    Debt execute(Debt debt);
}
