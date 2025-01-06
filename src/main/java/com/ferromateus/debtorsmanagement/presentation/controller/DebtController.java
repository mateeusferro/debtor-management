package com.ferromateus.debtorsmanagement.presentation.controller;

import com.ferromateus.debtorsmanagement.application.mapper.DebtDTOMapper;
import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.CreateDebtUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.debt.interfaces.GetDebtByIdUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debt;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/debt")
public class DebtController {

    CreateDebtUseCase createDebtUseCase;
    GetDebtByIdUseCase getDebtByIdUseCase;

    public DebtController(CreateDebtUseCase createDebtUseCase, GetDebtByIdUseCase getDebtByIdUseCase) {
        this.createDebtUseCase = createDebtUseCase;
        this.getDebtByIdUseCase = getDebtByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Debt> createDebt(@RequestBody DebtDTO debtDTO) {
        Debt debt = createDebtUseCase.execute(DebtDTOMapper.toDomain(debtDTO), debtDTO.debtorId());
        return ResponseEntity.status(HttpStatus.CREATED).body(debt);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Debt> getDebtById(@PathVariable UUID id) {
        Debt debt = getDebtByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(debt);
    }
}
