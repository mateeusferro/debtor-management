package com.ferromateus.debtorsmanagement.application.usecase.debtor.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.GetDebtorsUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtorGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;

import java.util.List;

public class GetDebtorsUseCaseImpl implements GetDebtorsUseCase {

    private final DebtorGateway debtorGateway;

    public GetDebtorsUseCaseImpl(DebtorGateway debtorGateway) {
        this.debtorGateway = debtorGateway;
    }

    @Override
    public List<Debtor> execute() {
        return debtorGateway.getDebtors();
    }
}
