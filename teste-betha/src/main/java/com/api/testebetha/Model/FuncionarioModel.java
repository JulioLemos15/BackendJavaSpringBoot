package com.api.testebetha.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "tb_funcionario")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, unique = true, length = 15)
    private String cpf;

    @Column(nullable = false, length = 15)
    private String endereco;

    @Column(nullable = false, unique = true, length = 15)
    private String telefone;

    @Column(nullable = false, unique = true, length = 15)
    private String email;

    @Column(nullable = false, length = 15)
    private String Senha;

    @Column(nullable = false, length = 25)
    private LocalDateTime dh_criacao;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    public EmpresaModel empresa;


}
