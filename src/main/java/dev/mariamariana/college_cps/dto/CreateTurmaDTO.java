package dev.mariamariana.college_cps.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CreateTurmaDTO implements Serializable {

    private Long id;
    private String codigo;
    private LocalDateTime dataInicio;
    private CursoDTO curso;
}
