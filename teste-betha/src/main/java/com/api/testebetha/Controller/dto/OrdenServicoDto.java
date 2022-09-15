package com.api.testebetha.Controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class OrdenServicoDto {
    @NotBlank
    private String Status;


}
