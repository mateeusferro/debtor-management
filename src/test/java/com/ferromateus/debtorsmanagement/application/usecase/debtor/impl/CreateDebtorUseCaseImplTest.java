package com.ferromateus.debtorsmanagement.application.usecase.debtor.impl;

import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.CreateDebtorUseCase;
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
class CreateDebtorUseCaseImplTest {

    @Autowired
    private DebtorRepository debtorRepository;
    private CreateDebtorUseCase createDebtorUseCase;
    private Debtor debtor;

    @BeforeEach
    void setUp() {
        DebtorRepositoryGateway debtorRepositoryGateway = new DebtorRepositoryGateway(debtorRepository);
        createDebtorUseCase = new CreateDebtorUseCaseImpl(debtorRepositoryGateway);
        debtor = new Debtor(null, "Address Test", "123.456.789-10", "test@test.com",
                "Test", "12345-7891", true);
    }

    @Test
    void execute() {
        Debtor savedDebtor = createDebtorUseCase.execute(debtor);

        assertNotNull(savedDebtor.getId());
        assertEquals(savedDebtor.getName(), debtor.getName());
        assertEquals(savedDebtor.getCpf(), debtor.getCpf());
        assertEquals(savedDebtor.getAddress(), debtor.getAddress());
        assertEquals(savedDebtor.getPhoneNumber(), debtor.getPhoneNumber());
        assertEquals(savedDebtor.getEmail(), debtor.getEmail());
        assertEquals(true, savedDebtor.getStatus());
    }
}