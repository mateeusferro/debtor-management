package com.ferromateus.debtorsmanagement.application.usecase.debt.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.GetDebtsUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtorRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtRepository;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class GetDebtsUseCaseImplTest {

    @Autowired
    private DebtRepository debtRepository;
    private GetDebtsUseCase getDebtsUseCase;

    @BeforeEach
    void setUp() {
        DebtRepositoryGateway debtRepositoryGateway = new DebtRepositoryGateway(debtRepository);
        getDebtsUseCase = new GetDebtsUseCaseImpl(debtRepositoryGateway);
    }

    @Test
    void execute() {
        List<Debt> debts = getDebtsUseCase.execute();
        assertFalse(debts.isEmpty());
    }
}