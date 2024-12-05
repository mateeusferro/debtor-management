package com.ferromateus.debtorsmanagement.infrastructure.persistence.repository;

import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DebtRepository extends CrudRepository<DebtEntity, UUID> {
}
