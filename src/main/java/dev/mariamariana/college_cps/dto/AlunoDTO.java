package dev.mariamariana.college_cps.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class AlunoDTO implements Serializable {
    private Long id;
    private String nome;
    private String contato;
}
