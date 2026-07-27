package com.aula.h2_jdbc.repository;

import com.aula.h2_jdbc.model.Turma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Long> {
    Turma findTurmaByCodigo(String codigo);
}