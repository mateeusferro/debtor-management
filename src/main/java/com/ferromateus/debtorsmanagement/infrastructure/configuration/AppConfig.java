package com.ferromateus.debtorsmanagement.infrastructure.configuration;

import com.ferromateus.debtorsmanagement.application.usecase.debt.impl.CreateDebtUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.debt.impl.GetDebtByIdUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.debt.impl.GetDebtsUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.CreateDebtUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.GetDebtByIdUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.GetDebtsUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.impl.CreateDebtorUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.impl.GetDebtorByIdUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.impl.GetDebtorsUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.CreateDebtorUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.GetDebtorByIdUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.GetDebtorsUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.payment.impl.CreatePaymentUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.payment.impl.GetPaymentByIdUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.payment.impl.GetPaymentsUseCaseImpl;
import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.CreatePaymentUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.GetPaymentByIdUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.payment.interfaces.GetPaymentsUseCase;
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

    @Bean
    CreateDebtorUseCase createDebtorUseCase(DebtorGateway debtorGateway) {
        return new CreateDebtorUseCaseImpl(debtorGateway);
    }

    @Bean
    GetDebtorByIdUseCase getDebtorByIdUseCase(DebtorGateway debtorGateway) {
        return new GetDebtorByIdUseCaseImpl(debtorGateway);
    }

    @Bean
    GetDebtorsUseCase getDebtorsUseCase(DebtorGateway debtorGateway) {
        return new GetDebtorsUseCaseImpl(debtorGateway);
    }

    @Bean
    CreateDebtUseCase createDebtUseCase(DebtGateway debtGateway, DebtorGateway debtorGateway) {
        return new CreateDebtUseCaseImpl(debtGateway, debtorGateway);
    }

    @Bean
    GetDebtByIdUseCase getDebtByIdUseCase(DebtGateway debtGateway) {
        return new GetDebtByIdUseCaseImpl(debtGateway);
    }

    @Bean
    GetDebtsUseCase getDebtsUseCase(DebtGateway debtGateway) {
        return new GetDebtsUseCaseImpl(debtGateway);
    }

    @Bean
    CreatePaymentUseCase createPaymentUseCase(PaymentGateway paymentGateway, DebtGateway debtGateway) {
        return new CreatePaymentUseCaseImpl(paymentGateway, debtGateway);
    }

    @Bean
    GetPaymentByIdUseCase getPaymentByIdUseCase(PaymentGateway paymentGateway) {
        return new GetPaymentByIdUseCaseImpl(paymentGateway);
    }

    @Bean
    GetPaymentsUseCase getPaymentsUseCase(PaymentGateway paymentGateway) {
        return new GetPaymentsUseCaseImpl(paymentGateway);
    }

}
