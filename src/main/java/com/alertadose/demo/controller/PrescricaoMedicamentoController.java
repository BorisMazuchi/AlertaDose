package com.alertadose.demo.controller;

import com.alertadose.demo.dto.PrescricaoMedicamentoDTO;
import com.alertadose.demo.entity.PrescricaoMedicamento;
import com.alertadose.demo.service.PrescricaoMedicamentoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/prescricao")
public class PrescricaoMedicamentoController {

    @Autowired
    private PrescricaoMedicamentoService prescricaoMedicamentoService;

    @PostMapping
    public ResponseEntity<PrescricaoMedicamentoDTO> create(PrescricaoMedicamentoDTO prescricaoMedicamentoDTO) {
       PrescricaoMedicamentoDTO prescricao =  prescricaoMedicamentoService.createPrescricao(prescricaoMedicamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(prescricao);
    }
}
