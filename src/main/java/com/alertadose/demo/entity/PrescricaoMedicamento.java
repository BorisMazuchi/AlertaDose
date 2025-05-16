package com.alertadose.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PrescricaoMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="paciente_id", nullable=false)
    private  Paciente paciente;

    @OneToOne
    @JoinColumn(name="medicamento_id", nullable=false)
    private Medicamento medicamento;

    @Column(nullable = false)
    private BigDecimal dose;

    @Column(nullable = false)
    private int frequencia;



}
