package com.alertadose.demo.mappers;

import com.alertadose.demo.dto.MedicamentoDTO;
import com.alertadose.demo.entity.Medicamento;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicamentoMapper {

    public MedicamentoDTO toDTO(Medicamento medicamento) {
        MedicamentoDTO medicamentoDTO = new MedicamentoDTO();
        medicamentoDTO.setId(medicamento.getId());
        medicamentoDTO.setNome(medicamento.getNome());
        medicamentoDTO.setDescricao(medicamento.getDescricao());
        medicamentoDTO.setOrigem(medicamento.getOrigem());
        medicamentoDTO.setComprado(medicamento.getComprado());
        return medicamentoDTO;
    }

    public List<MedicamentoDTO> toDTO(List<Medicamento> medicamentos) {
        List<MedicamentoDTO> medicamentoDTOs = new ArrayList<>();
        for(Medicamento medicamento : medicamentos){
            medicamentoDTOs.add(toDTO(medicamento));
        }
        return medicamentoDTOs;
    }

    public Medicamento toEntity(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = new Medicamento();
        medicamento.setId(medicamentoDTO.getId());
        medicamento.setNome(medicamentoDTO.getNome());
        medicamento.setDescricao(medicamentoDTO.getDescricao());
        medicamento.setOrigem(medicamentoDTO.getOrigem());
        medicamento.setComprado(medicamentoDTO.getComprado());
        return medicamento;
    }

    public List<Medicamento> toEntity(List<MedicamentoDTO> medicamentoDTOs) {
        List<Medicamento> medicamentos = new ArrayList<>();
        for(MedicamentoDTO medicamentoDTO : medicamentoDTOs){
            medicamentos.add(toEntity(medicamentoDTO));
        }
        return medicamentos;
    }

    public Medicamento merge(Medicamento medicamento, MedicamentoDTO dto) {
        if (dto.getComprado() != null) medicamento.setComprado(dto.getComprado());
        if (dto.getOrigem() != null) medicamento.setOrigem(dto.getOrigem());
        if (dto.getNome() != null) medicamento.setNome(dto.getNome());
        if (dto.getDescricao() != null) medicamento.setDescricao(dto.getDescricao());
        return medicamento;
    }
}
