package com.ferromateus.debtorsmanagement.presentation.controller;

import com.ferromateus.debtorsmanagement.application.mapper.DebtDTOMapper;
import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.CreateDebtUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/debt")
public class DebtController {

    CreateDebtUseCase createDebtUseCase;

    public DebtController(CreateDebtUseCase createDebtUseCase) {
        this.createDebtUseCase = createDebtUseCase;
    }

    @PostMapping
    public ResponseEntity<Debt> createDebt(@RequestBody DebtDTO debtDTO) {
        Debt debt = createDebtUseCase.execute(DebtDTOMapper.toDomain(debtDTO), debtDTO.debtorId());
        return ResponseEntity.status(HttpStatus.CREATED).body(debt);
    }
}
