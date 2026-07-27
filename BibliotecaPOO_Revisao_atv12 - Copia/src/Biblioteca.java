import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livrosDisponiveis = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro l){
        livrosDisponiveis.add(l);
    }

    public void adicionarEmprestimo(String titulo,
                                    LocalDate dataEmprestimo, LocalDate dataDevolucao){
        for(Livro l : livrosDisponiveis){
            if(titulo.equals(l.getTitulo())) {
                try {
                    l.emprestar();
                    Emprestimo emp = new Emprestimo(l, dataEmprestimo, dataDevolucao);
                    System.out.println("Emprestimo realizado!");
                    emp.exibirDetalhesEmprestimo();
                    emprestimos.add(emp);
                    return;
                }catch (LivroIndisponivelException ex){
                    System.out.println(ex.getMessage());
                    return;
                }
            }
        }System.out.println("Livro não encontrado!!!");
    }
}

