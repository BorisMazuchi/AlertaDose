package com.alertadose.demo.dto;

import com.alertadose.demo.enums.Medidas;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PrescricaoMedicamentoDTO {
    private Long id;
    private Long pacienteId;
    private Long medicamentoId;
    private BigDecimal dose;
    private Medidas medida;
    private Integer frequencia;
}
