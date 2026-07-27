package com.aula.h2_jdbc.service;

import com.aula.h2_jdbc.model.Aluno;
import com.aula.h2_jdbc.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

//    private final AlunoRepository alunoRepository2;
//
//    public AlunoService(AlunoRepository alunoRepository) {
//        this.alunoRepository = alunoRepository;
//    }
    public void salvarAluno (Aluno aluno){

        alunoRepository.save(aluno);

    }

    public Iterable<Aluno> listarTodasAlunos() {

        System.out.println("Listando todos os alunos");

        return alunoRepository.findAll();
    }

    public Aluno recuparAlunoPorId(Long id){
        return alunoRepository.findById(id).orElseThrow();
    }

}