package com.alertadose.demo.service;

import com.alertadose.demo.dto.MedicamentoDTO;
import com.alertadose.demo.entity.Medicamento;
import com.alertadose.demo.mappers.MedicamentoMapper;
import com.alertadose.demo.repository.MedicamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Autowired
    MedicamentoMapper mapper;

    public Medicamento createMedicamento(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = mapper.toEntity(medicamentoDTO);
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento updateMedicamento(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = mapper.toEntity(medicamentoDTO);
        return medicamentoRepository.save(medicamento);
    }

    public boolean deleteMedicamento(Long id){
        if(medicamentoRepository.findById(id).isPresent()){
            medicamentoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public List<MedicamentoDTO> getAllMedicamentos() {
        List<MedicamentoDTO> medicamentosDTO = mapper.toDTO(medicamentoRepository.findAll());
        return medicamentosDTO;
    }

    public Optional<MedicamentoDTO> getMedicamentoById(Long id){
        Optional<MedicamentoDTO> medicamento = Optional.ofNullable(mapper.toDTO(medicamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado"))));
        if(medicamento.isPresent()){
            return Optional.of(medicamento.get());
        }else{
            return Optional.empty();
        }
    }
}
