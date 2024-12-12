package com.ferromateus.debtorsmanagement.infrastructure.gateway;

import com.ferromateus.debtorsmanagement.application.mapper.DebtorMapper;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtorGateway;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtorEntity;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtorRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DebtorRepositoryGateway implements DebtorGateway {
    private final DebtorRepository debtorRepository;

    public DebtorRepositoryGateway(DebtorRepository debtorRepository) {
        this.debtorRepository = debtorRepository;
    }

    @Override
    public Debtor createDebtor(Debtor debtor) {
        DebtorEntity debtorEntity = DebtorMapper.toEntity(debtor);
        DebtorEntity savedDebtor = debtorRepository.save(debtorEntity);
        return DebtorMapper.toDomain(savedDebtor);
    }

    @Override
    public List<Debtor> getDebtors() {
        List<DebtorEntity> debtors = (List<DebtorEntity>) debtorRepository.findAll();
        return debtors.stream().map(DebtorMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Debtor getDebtor(UUID id) {
        DebtorEntity debtorEntity = debtorRepository.findById(id).orElse(null);
        return DebtorMapper.toDomain(debtorEntity);
    }

    @Override
    public Debtor updateDebtor(UUID id, Debtor debtor) {
        DebtorEntity debtorEntity = debtorRepository.findById(id).orElse(null);
        if (debtorEntity == null) throw new IllegalArgumentException("Debtor not found");

        debtorEntity.setId(debtor.getId());
        DebtorEntity debtorToUpdate = DebtorMapper.toEntity(debtor);
        DebtorEntity updatedDebtor = debtorRepository.save(debtorToUpdate);
        return DebtorMapper.toDomain(updatedDebtor);
    }

    // To do: instead deleting on DB, just setting is active to false
    @Override
    public void deleteDebtor(UUID id) {
        debtorRepository.deleteById(id);
    }
}
