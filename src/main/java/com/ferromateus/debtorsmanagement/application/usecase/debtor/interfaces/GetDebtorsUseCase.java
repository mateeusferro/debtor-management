package com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;

import java.util.List;

public interface GetDebtorsUseCase {
    List<Debtor> execute();
}
