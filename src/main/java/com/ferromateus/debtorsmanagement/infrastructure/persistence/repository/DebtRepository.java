package com.ferromateus.debtorsmanagement.infrastructure.persistence.repository;

import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.DebtEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DebtRepository extends CrudRepository<DebtEntity, UUID> {
}
