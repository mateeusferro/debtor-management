package com.ferromateus.debtorsmanagement.application.usecase.debtor.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.GetDebtorsUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtorRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class GetDebtorsUseCaseImplTest {

    @Autowired
    private DebtorRepository debtorRepository;
    private GetDebtorsUseCase getDebtorsUseCase;

    @BeforeEach
    void setUp() {
        DebtorRepositoryGateway debtorRepositoryGateway = new DebtorRepositoryGateway(debtorRepository);
        getDebtorsUseCase = new GetDebtorsUseCaseImpl(debtorRepositoryGateway);
    }

    @Test
    void execute() {
        List<Debtor> debtors = getDebtorsUseCase.execute();
        assertFalse(debtors.isEmpty());
    }
}