package com.ferromateus.debtorsmanagement.presentation.controller;

import com.ferromateus.debtorsmanagement.application.mapper.DebtorDTOMapper;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.CreateDebtorUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/debtor")
public class DebtorController {

    CreateDebtorUseCase createDebtorUseCase;

    public DebtorController(CreateDebtorUseCase createDebtorUseCase) {
        this.createDebtorUseCase = createDebtorUseCase;
    }

    @PostMapping
    public ResponseEntity<Debtor> createDebtor(@RequestBody DebtorDTO debtorDTO) {
        Debtor debtor = createDebtorUseCase.execute(DebtorDTOMapper.toDomain(debtorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(debtor);
    }
}
