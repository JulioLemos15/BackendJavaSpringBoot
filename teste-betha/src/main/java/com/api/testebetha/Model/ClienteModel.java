package com.api.testebetha.Model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private LocalDateTime registrationDate;

    public LocalDateTime getDh_criacao() {
        return dh_criacao;
    }

    public void setDh_criacao(LocalDateTime dh_criacao) {
        this.dh_criacao = dh_criacao;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

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

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

}
