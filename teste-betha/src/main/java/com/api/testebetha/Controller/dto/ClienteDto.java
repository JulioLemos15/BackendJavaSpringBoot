package com.api.testebetha.Controller.dto;

import com.api.testebetha.Model.EmpresaModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class ClienteDto {

    @NotBlank(message = "O nome é obrigatorio!")
    @Size(min = 4, message = "O nome deve ter no minimo 4 caracteres!")
    private String name;

    @NotBlank(message = "O endereço é obrigatorio!")
    private String endereco;

    @NotBlank(message = "O telefone é obrigatorio!")
    @Size(max = 15)
    private String telefone;

    @NotBlank(message = "O email é obrigatorio!")
    private String email;

    @NotBlank(message = "O cpf é obrigatorio!")
    @Size(max = 15)
    private String cpf_cnpj;

    @NotBlank
    private Long empresa;


}
