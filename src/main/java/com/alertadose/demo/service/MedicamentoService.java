package com.alertadose.demo.service;

import com.alertadose.demo.dto.MedicamentoDTO;
import com.alertadose.demo.entity.Medicamento;
import com.alertadose.demo.mappers.MedicamentoMapper;
import com.alertadose.demo.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Autowired
    MedicamentoMapper medicamentoMapper;

    public Medicamento createMedicamento(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = medicamentoMapper.toEntity(medicamentoDTO);
        return medicamentoRepository.save(medicamento);
    }
}
