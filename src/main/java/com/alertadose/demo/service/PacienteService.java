package com.alertadose.demo.service;

import com.alertadose.demo.dto.PacienteDTO;
import com.alertadose.demo.entity.Paciente;
import com.alertadose.demo.mappers.PacienteMapper;
import com.alertadose.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    PacienteMapper mapper;

    public Paciente createPaciente(PacienteDTO dto) {
        Paciente paciente = mapper.toEntity(dto);
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(PacienteDTO dto) {
        Paciente paciente = mapper.toEntity(dto);
        return pacienteRepository.save(paciente);
    }

    public boolean deletePaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()) {
           pacienteRepository.delete(paciente.get());
            return true;
        } else {
            return false;
        }
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> getPacienteById(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()) {
            return Optional.of(paciente.get());
        }else {
            return Optional.empty();
        }
    }
}
