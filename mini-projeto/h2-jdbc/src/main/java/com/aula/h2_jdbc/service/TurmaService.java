package com.aula.h2_jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.h2_jdbc.model.Aluno;
import com.aula.h2_jdbc.model.Turma;
import com.aula.h2_jdbc.repository.AlunoRepository;
import com.aula.h2_jdbc.repository.TurmaRepository;

@Service
public class TurmaService {

    private final AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    TurmaService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Iterable<Turma> listarTodasTurmas() {
        return turmaRepository.findAll();
    }

    public Turma salvarTurma(Turma turma) {
        Turma existente = turmaRepository.findTurmaByCodigo(turma.getCodigo());
        if (existente != null) {
            throw new IllegalArgumentException("Já existe uma turma com esse código!");
        }
        return turmaRepository.save(turma);
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id).orElse(null);
    }

    public Turma atualizarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deletarTurma(Long id) {
        turmaRepository.deleteById(id);
    }

    public List<Aluno> listarAlunosSemTurma() {
        return alunoRepository.findByTurmaIdIsNull();
    }

    public void vincularAluno(Long turmaId, Long alunoId) {
        var aluno = alunoRepository.findById(alunoId).orElseThrow();
        aluno.setTurmaId(turmaId);
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosComTurma() {
        List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();
        for (Aluno aluno : alunos) {
            if (aluno.getTurmaId() != null) {
                Turma turma = turmaRepository.findById(aluno.getTurmaId()).orElse(null);
                aluno.setTurma(turma);
            }
        }
        return alunos;
    }
}