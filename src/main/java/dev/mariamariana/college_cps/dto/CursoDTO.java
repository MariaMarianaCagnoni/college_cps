package dev.mariamariana.college_cps.dto;

import dev.mariamariana.college_cps.model.Professor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class CursoDTO implements Serializable {
    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
    private int cargaHoraria;
    private LocalDateTime createdAt;
    private Professor professor;
}
