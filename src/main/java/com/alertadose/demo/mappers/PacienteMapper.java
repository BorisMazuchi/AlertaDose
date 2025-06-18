package com.alertadose.demo.mappers;

import com.alertadose.demo.dto.PacienteDTO;
import com.alertadose.demo.entity.Paciente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<PacienteDTO> toDTO(List<Paciente> pacientes) {
        List<PacienteDTO> pacientesDTOS = new ArrayList<>();
        for(Paciente paciente : pacientes) {
            pacientesDTOS.add(toDTO(paciente));
        }
        return pacientesDTOS;
    }

    public Paciente toEntity(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        return paciente;
    }

    public List<Paciente> toEntity(List<PacienteDTO> pacienteDTOS) {
        List<Paciente> pacientes = new ArrayList<>();
        for(PacienteDTO pacienteDTO : pacienteDTOS) {
            pacientes.add(toEntity(pacienteDTO));
        }
        return pacientes;
    }

    public Paciente merge(Paciente paciente, PacienteDTO dto) {
        if (dto.getNome() != null) paciente.setNome(dto.getNome());
        if (dto.getCpf() != null) paciente.setCpf(dto.getCpf());
        if (dto.getDataNascimento() != null) paciente.setDataNascimento(dto.getDataNascimento());
        return paciente;
    }

}
