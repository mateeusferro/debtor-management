package com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;

import java.util.UUID;

public interface GetDebtorByIdUseCase {
    Debtor execute(UUID id);
}
