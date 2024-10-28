package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProfessorServiceAggregator implements IProfessorServiceAggregator{

    private final ICursoService cursoService;

    public ProfessorServiceAggregator(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Override
    public Page<Curso> findAllCursosByProfessorId(Long professorId, Pageable pageable) {
        return this.cursoService.findAllByProfessorId(professorId, pageable);
    }
}
