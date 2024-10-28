package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.Professor;
import dev.mariamariana.college_cps.repository.ProfessorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProfessorService extends BaseService<Professor, Long> implements IProfessorService  {
    private final ProfessorRepository professorRepository;
    private final CursoService cursoService;

    public ProfessorService(ProfessorRepository professorRepository, CursoService cursoService) {
        super(professorRepository);
        this.professorRepository = professorRepository;
        this.cursoService = cursoService;
    }

    public Page<Professor> findAllByNomePageable(String nome, Pageable pageable) {
        if (nome == null) return this.findPageable(pageable);
        return this.professorRepository.findAllByNome(nome, pageable);
    }

    @Override
    public boolean beforeDelete(Long id) {
        // remove id do professor dos cursos
        var cursosDoProfessor = this.cursoService.findAllByProfessorId(id, null);
        cursosDoProfessor.forEach(curso -> {
            curso.setProfessor(null);
            this.cursoService.update(curso.getId(), curso);
        });
        return true;
    }

}
