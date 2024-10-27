package dev.mariamariana.college_cps.repository;

import dev.mariamariana.college_cps.model.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    Page<Professor> findAllByNome(String nome, Pageable pageable);
}
