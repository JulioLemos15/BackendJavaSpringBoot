package com.api.testebetha.Controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FuncionarioDto {

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 15)
    private String cpf;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;

    @NotBlank
    private String email;

    @NotBlank
    private String Senha;


}
