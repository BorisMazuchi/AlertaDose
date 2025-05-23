package com.alertadose.demo.service;

import com.alertadose.demo.dto.PrescricaoMedicamentoDTO;
import com.alertadose.demo.entity.Medicamento;
import com.alertadose.demo.entity.Paciente;
import com.alertadose.demo.entity.PrescricaoMedicamento;
import com.alertadose.demo.mappers.PrescricaoMedicamentoMapper;
import com.alertadose.demo.repository.MedicamentoRepository;
import com.alertadose.demo.repository.PacienteRepository;
import com.alertadose.demo.repository.PrescricaoMedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescricaoMedicamentoService {

    @Autowired
    PrescricaoMedicamentoRepository prescricaoMedicamentoRepository;
    @Autowired
    MedicamentoRepository medicamentoRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    private PrescricaoMedicamentoMapper prescricaoMedicamentoMapper;

    public PrescricaoMedicamentoDTO createPrescricao( PrescricaoMedicamentoDTO dto) {
        System.out.println("DTO recebido:");
        System.out.println("Paciente ID: " + dto.getPacienteId());
        System.out.println("Medicamento ID: " + dto.getMedicamentoId());
        Medicamento medicamento = medicamentoRepository.findById(dto.getMedicamentoId())
                .orElseThrow(() -> new RuntimeException("Medicamento nao encontrado"));
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente nao encontrado"));
        PrescricaoMedicamento prescricaoMedicamento = new PrescricaoMedicamento();
        prescricaoMedicamento.setMedicamento(medicamento);
        prescricaoMedicamento.setPaciente(paciente);
        prescricaoMedicamento.setDose(dto.getDose());
        prescricaoMedicamento.setFrequencia(dto.getFrequencia());
        return prescricaoMedicamentoMapper.toDTO(prescricaoMedicamentoRepository.save(prescricaoMedicamento));
    }



}
