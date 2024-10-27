package dev.mariamariana.college_cps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "turma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turma implements BaseModel<Turma> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_cadastro")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;

    @Override
    public Turma safeUpdateInfo(Turma entity) {
        this.setCodigo(entity.getCodigo());
        this.setDataInicio(entity.getDataInicio());
        this.setCurso(entity.getCurso());
        return this;
    }
}
