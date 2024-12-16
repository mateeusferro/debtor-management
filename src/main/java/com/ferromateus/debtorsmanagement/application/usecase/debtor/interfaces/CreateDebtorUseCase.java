package com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;

public interface CreateDebtorUseCase {
    Debtor execute(Debtor debtor);
}
