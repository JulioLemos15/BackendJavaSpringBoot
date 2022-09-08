package com.api.testebetha.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LocalDateTime getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDateTime data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDateTime getData_termino() {
        return data_termino;
    }

    public void setData_termino(LocalDateTime data_termino) {
        this.data_termino = data_termino;
    }

    public EquipamentoModel getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentoModel equipamento) {
        this.equipamento = equipamento;
    }

    public FuncionarioModel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(FuncionarioModel responsavel) {
        this.responsavel = responsavel;
    }
}
