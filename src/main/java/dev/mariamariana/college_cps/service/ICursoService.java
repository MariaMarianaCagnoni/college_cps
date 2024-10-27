package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICursoService extends IBaseService<Curso, Long> {
    Page<Curso> findAllByProfessorId(Long professorId, Pageable pageable);
}
