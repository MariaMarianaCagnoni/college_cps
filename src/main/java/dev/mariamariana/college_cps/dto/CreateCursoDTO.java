package dev.mariamariana.college_cps.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class CreateCursoDTO implements Serializable {

    private String nome;
    private String descricao;
    private String categoria;
    private String cargaHoraria;
    private ProfessorDTO professor;
}
