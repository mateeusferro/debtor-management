package com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces;

import com.ferromateus.debtorsmanagement.domain.model.Debt;

import java.util.List;

public interface GetDebtsUseCase {
    List<Debt> execute();
}
