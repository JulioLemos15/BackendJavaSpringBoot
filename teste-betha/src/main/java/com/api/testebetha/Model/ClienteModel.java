package com.api.testebetha.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "tb_cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 45)
    public String name;

    @Column(nullable = false, length = 45)
    public String endereco;

    @Column(nullable = false, unique = true, length = 14)
    public String telefone;

    @Column(nullable = false, unique = true, length = 45)
    public String email;

    @Column(nullable = false, unique = true, length = 15)
    public String cpf_cnpj;

    @Column(nullable = false)
    private LocalDateTime dh_criacao;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    public EmpresaModel empresa;



}
