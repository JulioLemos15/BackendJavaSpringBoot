package com.api.testebetha.Model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tb_equipamento")
public class EquipamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String tipo_equipamento;

    @Column(nullable = false, length = 25)
    private String marca_equipamento;

    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    public ClienteModel cliente;


}
