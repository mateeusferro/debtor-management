package com.ferromateus.debtorsmanagement.infrastructure.persistence.repository;

import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DebtorRepository extends CrudRepository<DebtorEntity, UUID> {
}
