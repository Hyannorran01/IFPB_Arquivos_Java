package com.ProjetoFinal.goldestile.HomeController;
import com.ProjetoFinal.goldestile.model.Admin;
import com.ProjetoFinal.goldestile.model.Camisa;
import com.ProjetoFinal.goldestile.model.Cliente;
import com.ProjetoFinal.goldestile.service.AdminService;
import com.ProjetoFinal.goldestile.service.CamisaService;
import com.ProjetoFinal.goldestile.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController{

    private final AdminService adminService;
    private final CamisaService camisaService;
    private final ClienteService clienteService;

    public HomeController(AdminService adminService, CamisaService camisaService, ClienteService clienteService) {
        this.adminService = adminService;
        this.camisaService = camisaService;
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin";
    }

    @PostMapping("/autenticacao")
    public String autenticacao(@ModelAttribute Admin admin) {
        if (admin.getEmail().startsWith("admin") && admin.getSenha() == 1234){
            return "redirect:/admin";
        }else return "redirect:/index";
    }

    @GetMapping("/estoque")
    public String novaCamisa(Model model) {
        model.addAttribute("camisa", new Camisa());
        return "estoque";
    }

    @GetMapping("/produtos")
    public String listarprodutos(Model model){
        var camisas = camisaService.findAll();
        model.addAttribute("camisas", camisas);
        return "produtos";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Camisa camisa) {
        camisaService.save(camisa);
        return "redirect:/produtos";
    }

    @GetMapping("/cadastro")
    public String Novocliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro";
    }

    @GetMapping("/bancoCliente")
    public String listacliente(Model model){
        var clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "bancoCliente";
    }

    @PostMapping("/deletar-cadastro/{CPF}")
    public String deletarCadastro(@PathVariable int CPF) {
        clienteService.delete(CPF);
        return "redirect:/bancoCliente";
    }

    @PostMapping("/validarCadastro")
    public String validarCadastro(@ModelAttribute Cliente cliente) {
        if (cliente.getEmail().contains("@")){
            clienteService.save(cliente);
            return "redirect:/";
        }
        else{
            System.out.println("Formato de Email Inválido");
            return "cadastro";
        }
    }

    @PostMapping("/compraDeServicos/{ID}")
    public String compraDeServicos(@PathVariable int ID) {
        var camisaAtualizada = camisaService.findById(ID);
        if (camisaAtualizada.getQuantidade() == 0) {
            System.out.println("Estoque esgotado tente novamente mais tarde quando for atualizado");
            return "redirect:/index";
            }
        camisaAtualizada.setQuantidade(camisaAtualizada.getQuantidade() - 1);
        camisaService.save(camisaAtualizada);
        System.out.println("Compra realizada para a camisa ID " + ID);
        return "redirect:/produtos";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}




