package com.ferromateus.debtorsmanagement.application.usecase.debt.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.CreateDebtUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtGateway;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtorGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateDebtUseCaseImpl implements CreateDebtUseCase {

    private final DebtGateway debtGateway;
    private final DebtorGateway debtorGateway;

    public CreateDebtUseCaseImpl(DebtGateway debtGateway, DebtorGateway debtorGateway) {
        this.debtGateway = debtGateway;
        this.debtorGateway = debtorGateway;
    }

    @Override
    public Debt execute(Debt debt, UUID debtorId) {
        Debtor debtor = debtorGateway.getDebtor(debtorId);
        debt.setDebtor(debtor);
        debt.setCreatedDate(LocalDateTime.now());
        return debtGateway.createDebt(debt);
    }
}
