package com.api.testebetha.Model;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_equipamento() {
        return tipo_equipamento;
    }

    public void setTipo_equipamento(String tipo_equipamento) {
        this.tipo_equipamento = tipo_equipamento;
    }

    public String getMarca_equipamento() {
        return marca_equipamento;
    }

    public void setMarca_equipamento(String marca_equipamento) {
        this.marca_equipamento = marca_equipamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
