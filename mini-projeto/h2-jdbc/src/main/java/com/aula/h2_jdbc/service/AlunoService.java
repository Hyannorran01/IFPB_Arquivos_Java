package com.aula.h2_jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.h2_jdbc.model.Aluno;
import com.aula.h2_jdbc.repository.AlunoRepository;


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
    System.out.println("Aluno encontrado: " + alunoEncontrado);
    System.out.println("Aluno com nome maria: " +
            alunoRepository.countAlunoByNome("MARIA"));

    var alunoByNomeAndMatricula =  alunoRepository.findAlunoByNomeAndMatricula("ANA", "00006");
    System.out.println("Aluno encontrado: " + alunoByNomeAndMatricula);

    if (alunoEncontrado != null) {
        alunoEncontrado.setNome("MARIA atualizando");
        alunoRepository.save(alunoEncontrado);
    }

    return alunoRepository.findAll();
}

    public Aluno salvarAluno(Aluno aluno) {
        Aluno existente = alunoRepository.findAlunoByMatricula(aluno.getMatricula());
        if (existente != null) 
            throw new IllegalArgumentException("Já existe um aluno com essa matrícula!");
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
    }

    public Aluno atualizarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }


}