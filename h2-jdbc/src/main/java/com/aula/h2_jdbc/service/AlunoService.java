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

    public Iterable<Aluno> listarTodasAlunos() {

        System.out.println("Listando todos os alunos");

        var alunoEncontrado = alunoRepository.findByNome("MARIA");
        var aluno2 = alunoRepository.findUsandoSql("%MAR%");

        System.out.println("Aluno encontrado: " + alunoEncontrado);
        System.out.println("Aluno encontrado: " + aluno2);
        System.out.println("Aluno com nome maria: " +
                alunoRepository.countAlunoByNome("MARIA"));

        var alunoByNomeAndMatricula =  alunoRepository.findAlunoByNomeAndMatricula("ANA", "00006");

        System.out.println("Aluno encontrado: " + alunoByNomeAndMatricula);


        alunoRepository.save(new Aluno("teste", "00000019"));

        alunoEncontrado.setNome("MARIA atualizando");
        alunoRepository.save(alunoEncontrado);

        return alunoRepository.findAll();
    }



}