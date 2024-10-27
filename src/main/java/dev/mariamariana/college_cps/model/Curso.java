package dev.mariamariana.college_cps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso implements BaseModel<Curso> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @Column(name = "data_cadastro")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Override
    public Curso safeUpdateInfo(Curso entity) {
        this.setNome(entity.getNome());
        this.setDescricao(entity.getDescricao());
        this.setCargaHoraria(entity.getCargaHoraria());
        this.setCategoria(entity.getCategoria());
        this.setProfessor(entity.getProfessor());
        return this;
    }
}
