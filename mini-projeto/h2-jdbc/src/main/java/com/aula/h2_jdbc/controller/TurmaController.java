package com.aula.h2_jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aula.h2_jdbc.model.Aluno;
import com.aula.h2_jdbc.model.Turma;
import com.aula.h2_jdbc.service.AlunoService;
import com.aula.h2_jdbc.service.TurmaService;

@Controller
public class TurmaController {

    private final TurmaService turmaService;
    private final AlunoService alunoService;

    public TurmaController(TurmaService turmaService, AlunoService alunoService) {
        this.turmaService = turmaService;
        this.alunoService = alunoService;
    }

    @GetMapping("/turmas")
    public String listarTurmas(Model model) {
        var turmas = turmaService.listarTodasTurmas();
        model.addAttribute("turmas", turmas);
        return "turmas";
    }

    @GetMapping("/cadastro-turma")
    public String cadastroTurma(Model model) {
        return "cadastro-turma";
    }

    @PostMapping("/cadastro-turma")
    public String salvarTurma(Turma turma) {
        turmaService.salvarTurma(turma);
        return "redirect:/turmas";
    }

    @GetMapping("/editar-turma/{id}")
    public String editarTurma(@PathVariable Long id, Model model) {
        Turma turma = turmaService.buscarPorId(id);
        model.addAttribute("turma", turma);
        return "editar-turma";
    }

    @PostMapping("/editar-turma/{id}")
    public String atualizarTurma(@PathVariable Long id, Turma turma) {
        turma.setId(id);
        turmaService.atualizarTurma(turma);
        return "redirect:/turmas";
    }

    @PostMapping("/deletar-turma/{id}")
    public String deletarTurma(@PathVariable Long id) {
        turmaService.deletarTurma(id);
        return "redirect:/turmas";
    }

    @GetMapping("/vincular-aluno/{id}")
    public String vincularAlunoForm(@PathVariable Long id, Model model) {
        Turma turma = turmaService.buscarPorId(id);
        var alunos = turmaService.listarAlunosSemTurma(); 
        model.addAttribute("turma", turma);
        model.addAttribute("alunos", alunos);
        return "vincular-aluno";
    }

    @PostMapping("/vincular-aluno/{id}")
    public String vincularAluno(@PathVariable Long id, @RequestParam Long alunoId) {
        turmaService.vincularAluno(id, alunoId); 
        return "redirect:/turmas";
    }

    @GetMapping("/detalhes")
    public String listarAlunos(Model model) {
        var alunos = turmaService.listarTodosComTurma();
        model.addAttribute("alunos", alunos);
        return "detalhes";
    }

    @GetMapping("/detalhes-aluno/{id}")
    public String detalhesAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        if (aluno.getTurmaId() != null) {
            Turma turma = turmaService.buscarPorId(aluno.getTurmaId());
            aluno.setTurma(turma);
        }
        model.addAttribute("aluno", aluno);
        return "detalhes-aluno";
    }
}