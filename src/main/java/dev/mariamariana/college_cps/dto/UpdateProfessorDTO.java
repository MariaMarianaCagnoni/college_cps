package dev.mariamariana.college_cps.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateProfessorDTO implements Serializable {

    private String nome;
    private boolean ativo;
}
