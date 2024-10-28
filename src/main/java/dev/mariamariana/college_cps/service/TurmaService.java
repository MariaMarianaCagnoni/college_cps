package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public class TurmaService extends BaseService<Turma, Long> implements ITurmaService {
    public TurmaService(JpaRepository<Turma, Long> repository) {
        super(repository);
    }
}
