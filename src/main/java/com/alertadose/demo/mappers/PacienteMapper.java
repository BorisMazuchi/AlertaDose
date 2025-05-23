package com.alertadose.demo.mappers;

import com.alertadose.demo.dto.PacienteDTO;
import com.alertadose.demo.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public PacienteDTO toDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNome(paciente.getNome());
        pacienteDTO.setCpf(paciente.getCpf());
        pacienteDTO.setDataNascimento(paciente.getDataNascimento());
        return pacienteDTO;
    }

    public Paciente toEntity(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        return paciente;
    }
}
