package com.ferromateus.debtorsmanagement.infrastructure.persistence.repository;

import com.ferromateus.debtorsmanagement.infrastructure.persistence.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {
}
