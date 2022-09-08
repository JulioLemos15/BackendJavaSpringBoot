package com.api.testebetha.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteDto {

    @NotBlank
    private String name;
    @NotBlank
    private String endereco;
    @NotBlank
    @Size(max = 15)
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    @Size(max = 15)
    private String cpf_cnpj;

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
