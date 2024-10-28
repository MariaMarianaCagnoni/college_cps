package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.Curso;
import dev.mariamariana.college_cps.repository.CursoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CursoService extends BaseService<Curso, Long> implements ICursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        super(cursoRepository);
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Page<Curso> findAllByProfessorId(Long professorId, Pageable pageable) {
        return this.cursoRepository.findAllByProfessorId(professorId, pageable);
    }

    void deleteAllByProfessorId(Long professorId) {
        this.cursoRepository.deleteAllByProfessorId(professorId);
    }
}
