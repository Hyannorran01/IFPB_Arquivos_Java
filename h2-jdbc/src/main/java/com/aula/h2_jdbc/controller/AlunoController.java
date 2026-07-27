package com.aula.h2_jdbc.controller;

import com.aula.h2_jdbc.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
