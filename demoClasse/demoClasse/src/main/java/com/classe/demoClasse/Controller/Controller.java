import com.example.aula_thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


// Definiro banco  usa-se https://localhost:8080/h2-console
// https://localhost:8080/h2-aluno

@Controller
public class Controller {
    static List<aluno> alunosList = new ArrayList<>(
    );

    static List<turma> turmaList = new ArrayList<>(
            );

    static{
        alunosList.add(new aluno(101,"Luan", 15));
        alunosList.add(new aluno(102,"Roger", 17));
        alunosList.add(new aluno(103,"Ana", 18));
        alunosList.add(new aluno(104,"Roberto", 16));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("alunosList", alunosList);
        return "alunos";
    }

    @GetMapping("/turmas-cadastro")
    public String novoForm(Model model) {
        model.addAttribute("turma", new turma());
        return "turmas-cadastro";
    }

    @GetMapping("/aluno-cadastro")
    public String novoForm(Model model) {
        model.addAttribute("aluno", new aluno());
        return "aluno-cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute aluno aluno) {
        alunosList.add(aluno);
        return "redirect:/";
    }
    @PostMapping("/salvarTurma")
    public String salvarTurma(@ModelAttribute turma turma) {
        turmaList.add(turma);
        return "redirect:/";
    }

    @GetMapping("/detalhes/{matricula}")
    public String mostrarFormularioDeDetalhe(@PathVariable("matricula") String matricula, Model model) {
        aluno aluno = alunosList.stream().filter(u -> u.getMatricula().toString().equals(matricula)).findFirst().orElse(null);
        model.addAttribute("aluno", aluno);
        return "aluno-detalhe";
    }

    @GetMapping("/Apagar/{matricula}")
    public String mostrarFormularioDeEdicao(@PathVariable("matricula") String matricula, Model model) {
        aluno aluno = alunosList.stream().filter(u -> u.getMatricula().toString().equals(matricula)).findFirst().orElse(null);
        model.removeAttribute("aluno", aluno);
        return "aluno";
    }

    @GetMapping("/editar/{matricula}")
    public String mostrarFormularioDeEdicao(@PathVariable("matricula") String matricula, Model model) {
        aluno aluno = alunosList.stream().filter(u -> u.getMatricula().toString().equals(matricula)).findFirst().orElse(null);
        model.addAttribute("aluno", aluno);
        return "aluno-editar";
    }

    @PostMapping("/salvar-editar")
    public String salvarProduto(@ModelAttribute("aluno") aluno aluno, RedirectAttributes redirectAttributes) {
        try {
            users.forEach(i ->{
                if(i.getMatricula().equals(aluno.getMatricula())){i.setIdade(aluno.getIdade());i.setNome(aluno.getNome());}
            }
            );
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagem_erro", "Erro ao salvar o aluno.");
        }
        return "redirect:/";
    }
}