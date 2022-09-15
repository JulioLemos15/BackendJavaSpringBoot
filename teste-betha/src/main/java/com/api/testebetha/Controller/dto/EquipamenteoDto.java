package com.api.testebetha.Controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EquipamenteoDto {
    @NotBlank
    private String tipo_equipamento;

    @NotBlank
    private String marca_equipamento;

    @NotBlank
    private String descricao;

}
