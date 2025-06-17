package com.alertadose.demo.controller;

import com.alertadose.demo.dto.PacienteDTO;
import com.alertadose.demo.entity.Paciente;
import com.alertadose.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciented(@PathVariable Long id) {
        boolean deletado =  pacienteService.deletePaciente(id);
        if (deletado) {
            return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente inexistente");
        }
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.getAllPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable Long id) {
        Optional<PacienteDTO> paciente = pacienteService.getPacienteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(paciente.get());
    }

}
