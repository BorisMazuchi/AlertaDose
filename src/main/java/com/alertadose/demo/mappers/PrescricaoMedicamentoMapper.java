package com.alertadose.demo.mappers;

import com.alertadose.demo.dto.PrescricaoMedicamentoDTO;
import com.alertadose.demo.entity.Medicamento;
import com.alertadose.demo.entity.Paciente;
import com.alertadose.demo.entity.PrescricaoMedicamento;
import com.alertadose.demo.repository.MedicamentoRepository;
import com.alertadose.demo.repository.PacienteRepository;
import com.alertadose.demo.repository.PrescricaoMedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PrescricaoMedicamentoMapper {
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    MedicamentoMapper medicamentoMapper;
    @Autowired
    MedicamentoRepository medicamentoRepository;
    @Autowired
    PrescricaoMedicamentoRepository prescricaoMedicamentoRepository;

    public PrescricaoMedicamentoDTO toDTO(PrescricaoMedicamento prescricaoMedicamento) {
        PrescricaoMedicamentoDTO dto = new PrescricaoMedicamentoDTO();
        dto.setId(prescricaoMedicamento.getId());
        dto.setPacienteId(prescricaoMedicamento.getPaciente().getId());
        dto.setMedicamentoId(prescricaoMedicamento.getMedicamento().getId());
        dto.setDose(prescricaoMedicamento.getDose());
        dto.setFrequencia(prescricaoMedicamento.getFrequencia());
        dto.setMedida(prescricaoMedicamento.getMedida());
        return dto;
    }

    public List<PrescricaoMedicamentoDTO> toDTO(List<PrescricaoMedicamento> prescricoesMedicamento) {
        List<PrescricaoMedicamentoDTO> dtos = new ArrayList<>();
        for(PrescricaoMedicamento pescricao : prescricoesMedicamento ) {
            dtos.add(toDTO(pescricao));
        }
        return dtos;
    }

    public PrescricaoMedicamento toEntity(PrescricaoMedicamentoDTO dto) {
        PrescricaoMedicamento prescricao = new PrescricaoMedicamento();
        prescricao.setId(dto.getId());
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente nao encontrado"));
        prescricao.setPaciente(paciente);
        Medicamento medicamento = medicamentoRepository.findById(dto.getMedicamentoId())
                .orElseThrow(() -> new RuntimeException("Medicamento nao encontrado"));
        prescricao.setMedicamento(medicamento);
        prescricao.setDose(dto.getDose());
        prescricao.setFrequencia(dto.getFrequencia());
        prescricao.setMedida(dto.getMedida());
        return prescricao;
    }

    public List<PrescricaoMedicamento> toEntity(List<PrescricaoMedicamentoDTO> dtos) {
        List<PrescricaoMedicamento> prescricoesMedicamento = new ArrayList<>();
        for(PrescricaoMedicamentoDTO dto : dtos) {
            prescricoesMedicamento.add(toEntity(dto));
        }
        return prescricoesMedicamento;
    }

    public PrescricaoMedicamento merge (PrescricaoMedicamento prescricaoMedicamento, PrescricaoMedicamentoDTO dto) {
        if(dto.getDose() != null) prescricaoMedicamento.setDose(dto.getDose());
        Medicamento medicamento = medicamentoRepository.findById(dto.getMedicamentoId())
                .orElseThrow(() -> new RuntimeException("Medicamento nao encontrado"));
        if(dto.getMedicamentoId() != null) prescricaoMedicamento.setMedicamento(medicamento);
        if(dto.getMedida() != null) prescricaoMedicamento.setMedida(dto.getMedida());
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente nao encontrado"));
        if(dto.getPacienteId() != null) prescricaoMedicamento.setPaciente(paciente);
        if(dto.getFrequencia() != null) prescricaoMedicamento.setFrequencia(dto.getFrequencia());
        return prescricaoMedicamento;
    }
}
