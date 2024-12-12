package com.ferromateus.debtorsmanagement.infrastructure.gateway;

import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class DebtorRepositoryGatewayTest {

    @Autowired
    private DebtorRepository debtorRepository;
    private DebtorRepositoryGateway debtorRepositoryGateway;
    private Debtor debtor;
    private UUID debtorId;

    @BeforeEach
    void setUp() {
        debtorRepositoryGateway = new DebtorRepositoryGateway(debtorRepository);
        debtor = new Debtor(null, "Address Test", "123.456.789-10", "test@test.com",
                "Test", "12345-7891", true);
        Debtor savedDebtor = debtorRepositoryGateway.createDebtor(debtor);
        debtorId = savedDebtor.getId();
    }

    @Test
    void createDebtor() {
        Debtor savedDebtor = debtorRepositoryGateway.createDebtor(debtor);

        assertNotNull(savedDebtor.getId());
        assertEquals(savedDebtor.getName(), debtor.getName());
        assertEquals(savedDebtor.getCpf(), debtor.getCpf());
        assertEquals(savedDebtor.getAddress(), debtor.getAddress());
        assertEquals(savedDebtor.getPhoneNumber(), debtor.getPhoneNumber());
        assertEquals(savedDebtor.getStatus(), debtor.getStatus());
        assertEquals(savedDebtor.getEmail(), debtor.getEmail());
    }

    @Test
    void getDebtors() {
        List<Debtor> allDebtors = debtorRepositoryGateway.getDebtors();
        assertThat(allDebtors.size()).isNotZero();
    }

    @Test
    void getDebtor() {
        Debtor debtor = debtorRepositoryGateway.getDebtor(debtorId);
        assertNotNull(debtor);
    }

    @Test
    void updateDebtor() {
        Debtor debtorToUpdate = new Debtor(null, "Updated Address Test", "123.456.789-10", "updatedtest@test.com",
                "Updated Test", "12345-7891", true);
        Debtor updatedDebtor = debtorRepositoryGateway.updateDebtor(debtorId, debtorToUpdate);

        assertNotNull(updatedDebtor.getId());
        assertEquals(updatedDebtor.getName(), debtorToUpdate.getName());
        assertEquals(updatedDebtor.getCpf(), debtorToUpdate.getCpf());
        assertEquals(updatedDebtor.getAddress(), debtorToUpdate.getAddress());
        assertEquals(updatedDebtor.getPhoneNumber(), debtorToUpdate.getPhoneNumber());
        assertEquals(updatedDebtor.getStatus(), debtorToUpdate.getStatus());
        assertEquals(updatedDebtor.getEmail(), debtorToUpdate.getEmail());
    }

    @Test
    void deleteDebtor() {
        debtorRepositoryGateway.deleteDebtor(debtorId);
        assertThrows(IllegalArgumentException.class, () -> {
            debtorRepositoryGateway.getDebtor(debtorId);
        });
    }
}