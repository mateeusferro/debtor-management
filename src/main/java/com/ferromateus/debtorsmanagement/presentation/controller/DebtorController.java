package com.ferromateus.debtorsmanagement.presentation.controller;

import com.ferromateus.debtorsmanagement.application.mapper.DebtorDTOMapper;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.CreateDebtorUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.GetDebtorByIdUseCase;
import com.ferromateus.debtorsmanagement.application.usecase.debtor.interfaces.GetDebtorsUseCase;
import com.ferromateus.debtorsmanagement.domain.model.Debtor;
import com.ferromateus.debtorsmanagement.presentation.dto.DebtorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/debtor")
public class DebtorController {

    CreateDebtorUseCase createDebtorUseCase;
    GetDebtorByIdUseCase getDebtorByIdUseCase;
    GetDebtorsUseCase getDebtorsUseCase;

    public DebtorController(CreateDebtorUseCase createDebtorUseCase,
                            GetDebtorByIdUseCase getDebtorByIdUseCase,
                            GetDebtorsUseCase getDebtorsUseCase) {
        this.createDebtorUseCase = createDebtorUseCase;
        this.getDebtorByIdUseCase = getDebtorByIdUseCase;
        this.getDebtorsUseCase = getDebtorsUseCase;
    }

    @PostMapping
    public ResponseEntity<Debtor> createDebtor(@RequestBody DebtorDTO debtorDTO) {
        Debtor debtor = createDebtorUseCase.execute(DebtorDTOMapper.toDomain(debtorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(debtor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Debtor> getDebtorById(@PathVariable UUID id) {
        Debtor debtor = getDebtorByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(debtor);
    }

    @GetMapping
    public ResponseEntity<List<Debtor>> getDebtors() {
        List<Debtor> debtors = getDebtorsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(debtors);
    }

}
