package com.alertadose.demo.entity;

import com.alertadose.demo.enums.Medidas;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class PrescricaoMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="paciente_id", nullable=false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="medicamento_id", nullable=false)
    private Medicamento medicamento;

    @Column(nullable = false)
    private BigDecimal dose;

    @Column(nullable = false)
    private Integer frequencia;

    @Column(nullable = false)
    private Medidas medida;



}
