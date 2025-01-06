package com.ferromateus.debtorsmanagement.application.usecase.debt.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.GetDebtByIdUseCase;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class GetDebtByIdUseCaseImplTest {

    @Autowired
    private DebtRepository debtRepository;
    @Autowired
    private DebtorRepository debtorRepository;
    private GetDebtByIdUseCase getDebtByIdUseCase;
    private Debt debt;
    private Debtor debtor;

    @BeforeEach
    void setUp() {
        DebtorRepositoryGateway debtorRepositoryGateway = new DebtorRepositoryGateway(debtorRepository);
        DebtRepositoryGateway debtRepositoryGateway = new DebtRepositoryGateway(debtRepository);
        getDebtByIdUseCase = new GetDebtByIdUseCaseImpl(debtRepositoryGateway);

        debtor = new Debtor(null, "Address Test", "123.456.789-10", "test@test.com",
                "Test", "12345-7891", true);
        Debtor savedDebtor = debtorRepositoryGateway.createDebtor(debtor);
        debtor.setId(savedDebtor.getId());

        debt = new Debt(null, BigDecimal.valueOf(1000.55), LocalDateTime.of(2024, 10, 30, 12, 50, 55),
                "Test Debt", savedDebtor, LocalDate.of(2025, 1, 30), "Open");
        debt = debtRepositoryGateway.createDebt(debt);
    }

    @Test
    void execute() {
        Debt getDebt = getDebtByIdUseCase.execute(debt.getId());

        assertEquals(getDebt.getId(), debt.getId());
        assertEquals(debt.getCreatedDate(), getDebt.getCreatedDate());
        assertEquals(debt.getStatus(), getDebt.getStatus());
        assertEquals(debt.getDescription(), getDebt.getDescription());
        assertEquals(debt.getAmount(), getDebt.getAmount());
        assertEquals(debt.getDebtor(), getDebt.getDebtor());
        assertEquals(debt.getCreatedDate(), getDebt.getCreatedDate());
    }
}