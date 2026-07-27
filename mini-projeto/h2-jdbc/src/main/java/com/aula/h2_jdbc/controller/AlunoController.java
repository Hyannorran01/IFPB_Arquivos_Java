package com.aula.h2_jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.h2_jdbc.model.Aluno;
import com.aula.h2_jdbc.service.AlunoService;


@Controller
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        var alunos = alunoService.listarTodasAlunos();
        model.addAttribute("alunos", alunos);
        return "home";
    }

    @GetMapping("/cadastro-aluno")
    public String cadastroAluno(Model model) {
        var alunos = alunoService.listarTodasAlunos();
        model.addAttribute("alunos", alunos);
        return "cadastro-aluno";
    }

    @PostMapping("/cadastro-aluno")
    public String salvarAluno(Aluno aluno) {
        alunoService.salvarAluno(aluno);
        return "redirect:/cadastro-aluno";
    }

    @GetMapping("/editar-aluno/{id}")
    public String editarAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        model.addAttribute("aluno", aluno);
        return "editar-aluno";
    }   

    @PostMapping("/editar-aluno/{id}")
    public String atualizarAluno(@PathVariable Long id, Aluno aluno) {
        aluno.setId(id);
        alunoService.atualizarAluno(aluno);
        return "redirect:/";
    }

    @PostMapping("/deletar-aluno/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return "redirect:/";
    }
}
