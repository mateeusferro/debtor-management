package com.ferromateus.debtorsmanagement.domain.gateway;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;

import java.util.List;
import java.util.UUID;

public interface DebtorGateway {
    Debtor createDebtor(Debtor debtor);
    List<Debtor> getDebtors();
    Debtor getDebtor(UUID id);
    Debtor updateDebtor(UUID id, Debtor debtor);
    void deleteDebtor(UUID id);
}
