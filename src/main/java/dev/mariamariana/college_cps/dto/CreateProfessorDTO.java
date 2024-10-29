package dev.mariamariana.college_cps.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.io.Serializable;

@Data
public class CreateProfessorDTO implements Serializable {


    @NotEmpty(message = "Nome é obrigatório")
    private String nome;
    private boolean ativo;
}
