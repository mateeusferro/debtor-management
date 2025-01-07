package com.ferromateus.debtorsmanagement.application.usecase.debt.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.GetDebtsUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debt;

import java.util.List;

public class GetDebtsUseCaseImpl implements GetDebtsUseCase {

    private final DebtGateway debtGateway;

    public GetDebtsUseCaseImpl(DebtGateway debtGateway) {
        this.debtGateway = debtGateway;
    }

    @Override
    public List<Debt> execute() {
        return debtGateway.getDebts();
    }
}
