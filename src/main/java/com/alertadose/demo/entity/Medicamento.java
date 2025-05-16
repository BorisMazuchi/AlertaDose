package com.alertadose.demo.entity;

import com.alertadose.demo.enums.TipoOrigemMedicamentos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "medicamento")
@Getter
@Setter
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoOrigemMedicamentos origem;
}


