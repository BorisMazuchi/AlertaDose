package com.alertadose.demo.entity;

import com.alertadose.demo.enums.TipoOrigemMedicamentos;
import jakarta.persistence.*;

@Entity
@Table(name= "medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoOrigemMedicamentos origem;
    @ManyToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;
}


