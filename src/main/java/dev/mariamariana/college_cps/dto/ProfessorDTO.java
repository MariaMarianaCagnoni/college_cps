package dev.mariamariana.college_cps.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProfessorDTO implements Serializable {
    private Long id;
    private String nome;
    private LocalDateTime createdAt;

}
