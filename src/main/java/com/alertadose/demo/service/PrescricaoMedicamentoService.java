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

import java.util.List;

@Service
public class PrescricaoMedicamentoService {

    @Autowired
    PrescricaoMedicamentoRepository repository;
    @Autowired
    MedicamentoRepository medicamentoRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    private PrescricaoMedicamentoMapper mapper;

    public PrescricaoMedicamentoDTO createPrescricao( PrescricaoMedicamentoDTO dto) {
        Medicamento medicamento = medicamentoRepository.findById(dto.getMedicamentoId())
                .orElseThrow(() -> new RuntimeException("Medicamento nao encontrado"));
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente nao encontrado"));
        PrescricaoMedicamento prescricaoMedicamento = new PrescricaoMedicamento();
        prescricaoMedicamento.setMedicamento(medicamento);
        prescricaoMedicamento.setPaciente(paciente);
        prescricaoMedicamento.setDose(dto.getDose());
        prescricaoMedicamento.setFrequencia(dto.getFrequencia());
        return mapper.toDTO(repository.save(prescricaoMedicamento));
    }

    public PrescricaoMedicamentoDTO updatePescricao(PrescricaoMedicamentoDTO dto) {
        PrescricaoMedicamento pescricao = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(pescricao);
    }

    public boolean deletePrescricao(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public List<PrescricaoMedicamentoDTO> getAllPrescricao() {
       return mapper.toDTO(repository.findAll());
    }

    public PrescricaoMedicamentoDTO getPrescricaoById(Long id) {
        return mapper.toDTO(repository.findById(id).get());
    }

}
