package com.api.testebetha.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_empresa")
public class EmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;


}
