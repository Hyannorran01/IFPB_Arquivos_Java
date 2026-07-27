package com.example.aula_thymeleaf.controller;

import com.example.aula_thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {

    static List<User> users = new ArrayList<>(
    );

    static{
        users.add(new User(UUID.randomUUID(),"Teste", "test@gmail.com"));
        users.add(new User(UUID.randomUUID(),"Outro usuário", "test_other@gmail.com"));
        users.add(new User(UUID.randomUUID(),"Novo Teste", "new_test@gmail.com"));
        users.add(new User(UUID.randomUUID(),"Usuário Teste", "user-test@gmail.com"));
        users.add(new User(UUID.randomUUID(),"Aula Teste", "aula@gmail.com"));
        users.add(new User(UUID.randomUUID(),"Teste 1234", "test1234@gmail.com"));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", users);
        return "home";
    }

    @GetMapping("/cadastro-usuario")
    public String novoForm(Model model) {
        model.addAttribute("user", new User());
        return "cadastro-usuario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute User user) {
        users.add(user);
        return "redirect:/";
    }

    @GetMapping("/detalhes/{id}")
    public String mostrarFormularioDeDetalhe(@PathVariable("id") String id, Model model) {
        User user = users.stream().filter(u -> u.getId().toString().equals(id)).findFirst().orElse(null);
        model.addAttribute("usuario", user);
        return "detalhe-usuario";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable("id") String id, Model model) {
        User user = users.stream().filter(u -> u.getId().toString().equals(id)).findFirst().orElse(null);
        model.addAttribute("usuario", user);
        return "editar-usuario";
    }

    @PostMapping("/salvar-editar")
    public String salvarProduto(@ModelAttribute("usuario") User user, RedirectAttributes redirectAttributes) {
        try {

            users.forEach(u ->{
                    if(u.getId().equals(user.getId())){
                        u.setEmail(user.getEmail());
                        u.setName(user.getName());
                    }
            });

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagem_erro", "Erro ao salvar o usuário.");
        }
        return "redirect:/";
    }

}
