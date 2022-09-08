package com.api.testebetha.Model;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    public EmpresaModel empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }
}
