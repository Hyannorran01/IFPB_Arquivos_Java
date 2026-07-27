package com.aula.h2_jdbc.repository;

import com.aula.h2_jdbc.model.Aluno;
import com.aula.h2_jdbc.model.Turma;
import org.springframework.data.repository.CrudRepository;

public interface TurmaRepository extends CrudRepository<Turma, Long> {
}
