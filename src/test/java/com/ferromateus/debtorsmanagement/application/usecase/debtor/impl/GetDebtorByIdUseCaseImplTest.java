package com.ferromateus.debtorsmanagement.application.usecase.debtor.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.GetDebtorByIdUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtorRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class GetDebtorByIdUseCaseImplTest {

    @Autowired
    private DebtorRepository debtorRepository;
    private GetDebtorByIdUseCase getDebtorByIdUseCase;
    private Debtor debtor;

    @BeforeEach
    void setUp() {
        DebtorRepositoryGateway debtorRepositoryGateway = new DebtorRepositoryGateway(debtorRepository);
        getDebtorByIdUseCase = new GetDebtorByIdUseCaseImpl(debtorRepositoryGateway);
        debtor = new Debtor(null, "Address Test", "123.456.789-10", "test@test.com",
                "Test", "12345-7891", true);
        debtor = debtorRepositoryGateway.createDebtor(debtor);

    }

    @Test
    void execute() {
        Debtor getDebtor = getDebtorByIdUseCase.execute(debtor.getId());

        assertEquals(getDebtor.getId(), debtor.getId());
        assertEquals(getDebtor.getName(), debtor.getName());
        assertEquals(getDebtor.getCpf(), debtor.getCpf());
        assertEquals(getDebtor.getAddress(), debtor.getAddress());
        assertEquals(getDebtor.getPhoneNumber(), debtor.getPhoneNumber());
        assertEquals(getDebtor.getEmail(), debtor.getEmail());
        assertEquals(getDebtor.getStatus(), debtor.getStatus());
    }
}