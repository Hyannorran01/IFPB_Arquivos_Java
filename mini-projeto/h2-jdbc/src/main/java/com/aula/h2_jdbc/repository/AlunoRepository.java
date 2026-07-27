package com.aula.h2_jdbc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aula.h2_jdbc.model.Aluno;


@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    Aluno findByNome(String nome);
    Long countAlunoByNome(String nome);
    Aluno findAlunoByNomeAndMatricula(String nomeAluno, String matricula);
    Aluno findAlunoByMatricula(String matricula);
    List<Aluno> findByTurmaIdIsNull();
}
