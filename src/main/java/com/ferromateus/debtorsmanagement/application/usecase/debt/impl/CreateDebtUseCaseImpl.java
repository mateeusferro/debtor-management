package com.ferromateus.debtorsmanagement.application.usecase.debt.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.CreateDebtUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debt;

public class CreateDebtUseCaseImpl implements CreateDebtUseCase {

    private DebtGateway debtGateway;

    public CreateDebtUseCaseImpl(DebtGateway debtGateway) {
        this.debtGateway = debtGateway;
    }

    @Override
    public Debt execute(Debt debt) {
        return null;
    }
}
