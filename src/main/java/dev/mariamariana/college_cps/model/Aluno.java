package dev.mariamariana.college_cps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


    @Entity
    @Table(name = "aluno")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Aluno implements BaseModel<Aluno> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "nome")
        private String nome;

        @Column(name = "contato")
        private String contato;

        @Column(name = "data_cadastro")
        private LocalDateTime createdAt;

        @ManyToOne
        @JoinColumn(name = "turma")
        private Turma turma;

        @Override
        public Aluno safeUpdateInfo(Aluno entity) {
            this.setNome(entity.getNome());
            this.setContato(entity.getContato());
            this.setTurma(entity.getTurma());
            return this;
        }
}