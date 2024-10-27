package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProfessorService extends IBaseService<Professor, Long> {
    Page<Professor> findAllByNomePageable(String nome, Pageable pageable);
}
