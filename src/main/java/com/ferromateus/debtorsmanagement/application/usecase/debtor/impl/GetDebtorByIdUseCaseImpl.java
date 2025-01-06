package com.ferromateus.debtorsmanagement.application.usecase.debtor.impl;


import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.GetDebtorByIdUseCase;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtorGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;

import java.util.UUID;

public class GetDebtorByIdUseCaseImpl implements GetDebtorByIdUseCase {
    private final DebtorGateway debtorGateway;

    public GetDebtorByIdUseCaseImpl(DebtorGateway debtorGateway) {
        this.debtorGateway = debtorGateway;
    }

    @Override
    public Debtor execute(UUID id) {
        return debtorGateway.getDebtor(id);
    }
}
