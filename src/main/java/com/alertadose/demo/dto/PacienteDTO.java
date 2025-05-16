package com.alertadose.demo.dto;

import com.alertadose.demo.entity.Medicamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String cpf;
    private LocalDate dataNascimento;
}
