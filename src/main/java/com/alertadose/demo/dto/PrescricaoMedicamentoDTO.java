package com.alertadose.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PrescricaoMedicamentoDTO {
    private Long id;
    private Long pacienteId;
    private Long medicamentoId;
    private BigDecimal dose;
    private int frequencia;
}
