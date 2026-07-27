package com.aula.h2_jdbc.controller;

import com.aula.h2_jdbc.model.Turma;
import com.aula.h2_jdbc.repository.TurmaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TurmaController {
    private final TurmaRepository turmaRepo;

    public TurmaController(TurmaRepository turmaRepo) {
        this.turmaRepo = turmaRepo;
    }

    @GetMapping("/turmas")
    public String listar(Model model) {
        model.addAttribute("turmas", turmaRepo.findAll());
        return "turmas-html";
    }


    @GetMapping("/turmas/novo")
    public String nova(Model model) {
        model.addAttribute("turma", new Turma());
        return "turma-cadastro";
    }

    @PostMapping("/turmas/salvar")
    public String salvar(@ModelAttribute Turma turma) {
        turmaRepo.save(turma);
        return "redirect:/turmas";
    }
}
