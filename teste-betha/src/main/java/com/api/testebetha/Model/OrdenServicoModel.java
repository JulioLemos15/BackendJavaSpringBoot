package com.api.testebetha.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
@Entity
@Table(name = "tb_ods")
public class OrdenServicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String Status;

    @Column(nullable = false, length = 25)
    private LocalDateTime data_inicio;

    @Column(nullable = false, length = 25)
    private LocalDateTime data_termino;

    @ManyToOne
    @JoinColumn(name = "tb_equipamento")
    public EquipamentoModel equipamento;

    @ManyToOne
    @JoinColumn(name = "tb_responsavel")
    public FuncionarioModel responsavel;


}
