package dev.mariamariana.college_cps.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TurmaDTO implements Serializable {
    private Long id;
    private String codigo;
    private LocalDateTime dataInicio;
    private LocalDateTime createdAt;
    private TurmaCursoDTO curso;


}
