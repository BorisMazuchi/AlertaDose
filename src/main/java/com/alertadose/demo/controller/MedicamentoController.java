package com.alertadose.demo.controller;

import com.alertadose.demo.dto.MedicamentoDTO;
import com.alertadose.demo.entity.Medicamento;
import com.alertadose.demo.mappers.MedicamentoMapper;
import com.alertadose.demo.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        boolean deletado = medicamentoService.deleteMedicamento(id);
        if (deletado) {
            return ResponseEntity.status(HttpStatus.OK).body("Medicamento deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicamento inexistente");
        }
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.getAllMedicamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> getMedicamentoById(@PathVariable Long id) {
        Optional<MedicamentoDTO> medicamentoDTO = medicamentoService.getMedicamentoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoDTO.get());
    }

}

