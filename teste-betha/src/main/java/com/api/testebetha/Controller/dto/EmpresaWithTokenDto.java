package com.api.testebetha.Controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaWithTokenDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String email;

    @NotBlank
    private String token;
}
