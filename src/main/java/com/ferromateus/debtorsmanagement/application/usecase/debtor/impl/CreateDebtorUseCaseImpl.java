package com.ferromateus.debtorsmanagement.application.usecase.debtor.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.CreateDebtorUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtorGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;

public class CreateDebtorUseCaseImpl implements CreateDebtorUseCase {

    private final DebtorGateway debtorGateway;

    public CreateDebtorUseCaseImpl(DebtorGateway debtorGateway) {
        this.debtorGateway = debtorGateway;
    }

    @Override
    public Debtor execute(Debtor debtor) {
        debtor.setStatus(true);
        return debtorGateway.createDebtor(debtor);
    }
}
