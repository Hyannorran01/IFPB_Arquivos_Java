package com.aula.h2_jdbc.controller;

import com.aula.h2_jdbc.model.Aluno;
import com.aula.h2_jdbc.model.Turma;
import com.aula.h2_jdbc.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService ) {
        this.alunoService = alunoService;

    }

    @GetMapping("/")
    public String home(Model model) {
        var alunos = alunoService.listarTodasAlunos();
        model.addAttribute("alunos", alunos);
        return "home";
    }

    @GetMapping("/alunos/detalhes/{id}")
    public String exibirAlunoDetalhe(@PathVariable("id") Long id,Model model) {
        model.addAttribute("aluno", alunoService.recuparAlunoPorId(id));
        return "aluno-detalhe";
    }
    @GetMapping("/tumas/html/{id}")
    public String exibirTurmasHtml(@PathVariable("id") Long id,Model model) {
        model.addAttribute("aluno", alunoService.recuparAlunoPorId(id));
        return "turmas-html";
    }


    @GetMapping("/alunos/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("turmas", new Turma());
        return "aluno-cadastro";
    }

    @GetMapping("/alunos/editar/{id}")
    public String exibirAlunoEditar(@PathVariable("id") Long id,Model model) {
        var aluno = alunoService.recuparAlunoPorId(id);
        model.addAttribute("aluno",aluno );
        model.addAttribute("turmas", new Turma());
        return "aluno-editar";
    }


    @PostMapping("/alunos/atualizar")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
         alunoService.salvarAluno(aluno);
        return "redirect:/";
    }


}
