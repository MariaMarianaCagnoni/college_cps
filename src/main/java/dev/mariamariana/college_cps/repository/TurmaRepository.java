package dev.mariamariana.college_cps.repository;

import dev.mariamariana.college_cps.model.Turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
