package dev.mariamariana.college_cps.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TurmaCursoDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
    private int cargaHoraria;
}
