package com.ferromateus.debtorsmanagement.domain.gateway;

import com.ferromateus.debtorsmanagement.domain.model.Debt;

import java.util.List;
import java.util.UUID;

public interface DebtGateway {
    Debt createDebt(Debt debt);
    List<Debt> getDebts();

    // In future
//    List<Debt> getDebts(int size, int offset);
    List<Debt> getDebtsByDebtor(UUID debtorId);
    Debt getDebt(UUID id);
    Debt updateDebt(UUID id, Debt debt);
    void deleteDebt(UUID id);
}
