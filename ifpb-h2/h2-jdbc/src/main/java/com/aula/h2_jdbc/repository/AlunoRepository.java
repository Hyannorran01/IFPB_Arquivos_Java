package com.aula.h2_jdbc.repository;

import com.aula.h2_jdbc.model.Aluno;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {


    Aluno findByNome(String nome);

    @Query("select * from aluno where nome LIKE :nomeAluno")
    List<Aluno> findUsandoSql(String nomeAluno);


    Long countAlunoByNome( String nome);


    Aluno findAlunoByNomeAndMatricula(String nomeAluno, String matricula);

}
