package com.alertadose.demo.service;

import com.alertadose.demo.dto.PacienteDTO;
import com.alertadose.demo.entity.Paciente;
import com.alertadose.demo.mappers.PacienteMapper;
import com.alertadose.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
