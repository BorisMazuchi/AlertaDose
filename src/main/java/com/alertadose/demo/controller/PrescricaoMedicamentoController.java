package com.alertadose.demo.controller;

import com.alertadose.demo.dto.PrescricaoMedicamentoDTO;
import com.alertadose.demo.service.PrescricaoMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/prescricao")
public class PrescricaoMedicamentoController {

    @Autowired
    private PrescricaoMedicamentoService service;

    @PostMapping
    public ResponseEntity<PrescricaoMedicamentoDTO> create(@RequestBody PrescricaoMedicamentoDTO prescricaoMedicamentoDTO) {
       PrescricaoMedicamentoDTO prescricao =  service.createPrescricao(prescricaoMedicamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(prescricao);
    }

    @PutMapping
    public ResponseEntity<PrescricaoMedicamentoDTO> updatePescricao(@RequestBody PrescricaoMedicamentoDTO prescricaoMedicamentoDTO) {
        PrescricaoMedicamentoDTO pescricao = service.updatePescricao(prescricaoMedicamentoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pescricao);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<String> deletePescricao(@PathVariable Long id) {
        boolean deletado = service.deletePrescricao(id);
        if (deletado) {
            return ResponseEntity.status(HttpStatus.OK).body("Pescricao deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pescricao não encontrada");
        }
    }

    @GetMapping
    public ResponseEntity<List<PrescricaoMedicamentoDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPrescricao());
    }

    @GetMapping("{/id}")
    public ResponseEntity<PrescricaoMedicamentoDTO> getPrescricaoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPrescricaoById(id));
    }

}
