package com.ferromateus.debtorsmanagement.infrastructure.persistence.repository;

import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DebtorRepository extends CrudRepository<DebtorEntity, UUID> {
}
