package com.aula.h2_jdbc.service;

import com.aula.h2_jdbc.model.Turma;
import com.aula.h2_jdbc.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Iterable<Turma> listarTurmas() {
        return turmaRepository.findAll();


    }
}
