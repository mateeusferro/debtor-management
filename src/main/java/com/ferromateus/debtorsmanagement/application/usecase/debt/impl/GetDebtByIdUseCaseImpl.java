package com.ferromateus.debtorsmanagement.application.usecase.debt.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.GetDebtByIdUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debt;

import java.util.UUID;

public class GetDebtByIdUseCaseImpl implements GetDebtByIdUseCase {

    private final DebtGateway debtGateway;

    public GetDebtByIdUseCaseImpl(DebtGateway debtGateway) {
        this.debtGateway = debtGateway;
    }

    @Override
    public Debt execute(UUID id) {
        return debtGateway.getDebt(id);
    }
}
