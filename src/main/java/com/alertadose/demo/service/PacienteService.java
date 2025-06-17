package com.alertadose.demo.service;

import com.alertadose.demo.dto.PacienteDTO;
import com.alertadose.demo.entity.Paciente;
import com.alertadose.demo.mappers.PacienteMapper;
import com.alertadose.demo.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        if (pacienteRepository.findById(id).isPresent()) {
           pacienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<PacienteDTO> getAllPacientes() {
        List<PacienteDTO> pacientesDTO = mapper.toDTO(pacienteRepository.findAll());
        return pacientesDTO;
    }

    public Optional<PacienteDTO> getPacienteById(Long id) {
        Optional<PacienteDTO> paciente = Optional.ofNullable(mapper.toDTO(pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"))));
        if (paciente.isPresent()) {
            return Optional.of(paciente.get());
        }else {
            return Optional.empty();
        }
    }
}
