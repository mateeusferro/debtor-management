package com.ferromateus.debtorsmanagement.infrastructure.gateway;

import com.ferromateus.debtorsmanagement.domain.exception.ItemNotFoundException;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
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
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class DebtRepositoryGatewayTest {

    @Autowired
    private DebtRepository debtRepository;
    @Autowired
    private DebtorRepository debtorRepository;
    private DebtRepositoryGateway debtRepositoryGateway;
    private Debt debt;
    private UUID debtId;
    private Debtor debtor;

    @BeforeEach
    void setUp() {
        DebtorRepositoryGateway debtorRepositoryGateway = new DebtorRepositoryGateway(debtorRepository);
        debtRepositoryGateway = new DebtRepositoryGateway(debtRepository);
        debtor = new Debtor(null, "Address Test", "123.456.789-10", "test@test.com",
                "Test", "12345-7891", true);
        Debtor savedDebtor = debtorRepositoryGateway.createDebtor(debtor);
        debtor.setId(savedDebtor.getId());

        debt = new Debt(null, BigDecimal.valueOf(1000), LocalDateTime.of(2024, 10, 30, 12, 50, 55),
                "Test Debt", savedDebtor, LocalDate.of(2025, 1, 30), "Open");
        Debt savedDebt = debtRepositoryGateway.createDebt(debt);
        debtId = savedDebt.getId();
    }

    @Test
    void createDebt() {
        Debt savedDebt = debtRepositoryGateway.createDebt(debt);

        assertNotNull(savedDebt.getId());
        assertEquals(savedDebt.getStatus(), debt.getStatus());
        assertEquals(savedDebt.getAmount(), debt.getAmount());
        assertEquals(savedDebt.getDescription(), debt.getDescription());
        assertEquals(savedDebt.getDebtor(), debt.getDebtor());
        assertEquals(savedDebt.getCreatedDate(), debt.getCreatedDate());
        assertEquals(savedDebt.getDueDate(), debt.getDueDate());
    }

    @Test
    void getDebts() {
        List<Debt> debts = debtRepositoryGateway.getDebts();

        assertThat(debts.size()).isNotZero();
    }

    @Test
    void getDebt() {
        Debt debt = debtRepositoryGateway.getDebt(debtId);
        assertNotNull(debt);
    }

    @Test
    void getDebtsByDebtor() {
        List<Debt> debts = debtRepositoryGateway.getDebtsByDebtor(debtor.getId());
        assertTrue(debts.isEmpty());
    }

    @Test
    void updateDebt() {
        Debt debtToUpdate = new Debt(null, BigDecimal.valueOf(1000), LocalDateTime.of(2024, 10, 30, 12, 50, 55),
                "Test Debt", debtor, LocalDate.of(2025, 1, 30), "Open");
        Debt updatedDebt = debtRepositoryGateway.updateDebt(debtId, debtToUpdate);

        assertNotNull(updatedDebt.getId());
        assertEquals(updatedDebt.getStatus(), debt.getStatus());
        assertEquals(updatedDebt.getAmount(), debt.getAmount());
        assertEquals(updatedDebt.getDescription(), debt.getDescription());
        assertEquals(updatedDebt.getDebtor(), debt.getDebtor());
        assertEquals(updatedDebt.getCreatedDate(), debt.getCreatedDate());
        assertEquals(updatedDebt.getDueDate(), debt.getDueDate());
    }

    @Test
    void deleteDebt() {
        debtRepositoryGateway.deleteDebt(debtId);
        assertThrows(ItemNotFoundException.class, () -> {
            debtRepositoryGateway.getDebt(debtId);
        });
    }
}