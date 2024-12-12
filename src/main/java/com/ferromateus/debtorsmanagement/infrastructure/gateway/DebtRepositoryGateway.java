package com.ferromateus.debtorsmanagement.infrastructure.gateway;

import com.ferromateus.debtorsmanagement.application.mapper.DebtMapper;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtEntity;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DebtRepositoryGateway implements DebtGateway {
    private final DebtRepository debtRepository;

    public DebtRepositoryGateway(DebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }

    @Override
    public Debt createDebt(Debt debt) {
        DebtEntity debtEntity = DebtMapper.toEntity(debt);
        DebtEntity savedDebt = debtRepository.save(debtEntity);
        return DebtMapper.toDomain(savedDebt);
    }

    @Override
    public List<Debt> getDebts() {
        List<DebtEntity> debts = (List<DebtEntity>) debtRepository.findAll();
        return debts.stream().map(DebtMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Debt> getDebtsByDebtor(UUID debtorId) {
        return List.of();
    }

    @Override
    public Debt getDebt(UUID id) {
        DebtEntity debtEntity = debtRepository.findById(id).orElse(null);
        return DebtMapper.toDomain(debtEntity);
    }

    @Override
    public Debt updateDebt(UUID id, Debt debt) {
        DebtEntity debtEntity = debtRepository.findById(id).orElse(null);
        if (debtEntity == null) throw new IllegalArgumentException("Debt not found");

        debtEntity.setId(debt.getId());
        DebtEntity debtToUpdate = DebtMapper.toEntity(debt);
        DebtEntity updatedDebt = debtRepository.save(debtToUpdate);
        return DebtMapper.toDomain(updatedDebt);
    }

    // To do: instead deleting on DB, just setting is active to false
    @Override
    public void deleteDebt(UUID id) {
        debtRepository.deleteById(id);
    }
}
