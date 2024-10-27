package dev.mariamariana.college_cps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor implements BaseModel<Professor> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_cadastro")
    private LocalDateTime createdAt;

    @Column(name = "ativo")
    private boolean ativo;

    @Override
    public Professor safeUpdateInfo(Professor professor) {
        this.setNome(professor.getNome());
        this.setAtivo(professor.isAtivo());
        return this;
    }
}
