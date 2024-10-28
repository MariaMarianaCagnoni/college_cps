package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.Aluno;
import dev.mariamariana.college_cps.repository.AlunoRepository;

public class AlunoService extends BaseService<Aluno,Long> implements IAlunoService {
    public AlunoService(AlunoRepository repository) {
        super(repository);
    }
}
