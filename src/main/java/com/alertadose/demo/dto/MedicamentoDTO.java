package com.alertadose.demo.dto;
import com.alertadose.demo.enums.TipoOrigemMedicamentos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicamentoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private TipoOrigemMedicamentos origem;
}

