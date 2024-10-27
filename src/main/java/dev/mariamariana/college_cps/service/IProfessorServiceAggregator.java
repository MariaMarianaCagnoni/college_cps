package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.Curso;
import dev.mariamariana.college_cps.model.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProfessorServiceAggregator extends IBaseService<Professor, Long> {

    Page<Curso> findAllCursosByProfessorId(Long professorId, Pageable pageable);
}
