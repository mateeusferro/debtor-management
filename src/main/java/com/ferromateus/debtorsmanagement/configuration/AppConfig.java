package com.ferromateus.debtorsmanagement.configuration;

import com.ferromateus.debtorsmanagement.domain.gateway.DebtGateway;
import com.ferromateus.debtorsmanagement.domain.gateway.DebtorGateway;
import com.ferromateus.debtorsmanagement.domain.gateway.PaymentGateway;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.DebtorRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.gateway.PaymentRepositoryGateway;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtRepository;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.DebtorRepository;
import com.ferromateus.debtorsmanagement.infrastructure.persistence.repository.PaymentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    DebtorGateway debtorGateway(DebtorRepository debtorRepository) {
        return new DebtorRepositoryGateway(debtorRepository);
    }

    @Bean
    DebtGateway debtGateway(DebtRepository debtRepository) {
        return new DebtRepositoryGateway(debtRepository);
    }

    @Bean
    PaymentGateway paymentGateway(PaymentRepository paymentRepository) {
        return new PaymentRepositoryGateway(paymentRepository);
    }
}
