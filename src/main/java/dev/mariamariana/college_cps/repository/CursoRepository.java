package dev.mariamariana.college_cps.repository;

import dev.mariamariana.college_cps.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
    Page<Curso> findAllByProfessorId(Long professorId, Pageable pageable);

    void deleteAllByProfessorId(Long professorId);
}
