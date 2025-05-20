package com.alertadose.demo.controller;

import com.alertadose.demo.dto.MedicamentoDTO;
import com.alertadose.demo.entity.Medicamento;
import com.alertadose.demo.mappers.MedicamentoMapper;
import com.alertadose.demo.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {

    @Autowired
    MedicamentoService medicamentoService;

    @Autowired
    MedicamentoMapper medicamentoMapper;

    @PostMapping
    public ResponseEntity<Medicamento> create(@RequestBody MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = medicamentoService.createMedicamento(medicamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicamento);
    }

    @PutMapping
    public ResponseEntity<Medicamento> update(@RequestBody MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = medicamentoService.createMedicamento(medicamentoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(medicamento);
    }
}

