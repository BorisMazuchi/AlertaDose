package com.alertadose.demo.mappers;

import com.alertadose.demo.dto.PacienteDTO;
import com.alertadose.demo.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public static PacienteDTO toDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setCpf(paciente.getCpf());
        pacienteDTO.setDataNascimento(paciente.getDataNascimento());
        pacienteDTO.setMedicamentos(paciente.getMedicamentos()); // mudar para dto ao criar o DTO
        return pacienteDTO;
    }

    public static Paciente toEntity(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setMedicamentos(pacienteDTO.getMedicamentos());
        return paciente;
    }
}
