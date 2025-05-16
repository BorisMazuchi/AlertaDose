package com.alertadose.demo.controller;

import com.alertadose.demo.dto.PacienteDTO;
import com.alertadose.demo.entity.Paciente;
import com.alertadose.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> addPaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteService.createPaciente(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }

    @PutMapping
    public ResponseEntity<Paciente> updatePaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteService.createPaciente(pacienteDTO);
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }
}
