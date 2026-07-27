import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
            Biblioteca biblioIFPB = new Biblioteca();

            Livro l1 = new Livro("Java use a Cabeça!");
            Livro l2 = new Livro("Banco de Dados");
            LivroDigital l3 = new LivroDigital("CD Java");

            biblioIFPB.adicionarLivro(l1);
            biblioIFPB.adicionarLivro(l2);
            biblioIFPB.adicionarLivro(l3);

            biblioIFPB.adicionarEmprestimo("Java use a Cabeça!",
                    LocalDate.now(), LocalDate.now().plusDays(5));

            biblioIFPB.adicionarEmprestimo("Banco de Dados",
                    LocalDate.now(), LocalDate.now().plusDays(10));

            biblioIFPB.adicionarEmprestimo("CD java",
                    LocalDate.now(), LocalDate.now().plusDays(7));

            System.out.println("\n Tentando realizar emprestimo do Livro Java");
//Novo emprestimo!!!
            biblioIFPB.adicionarEmprestimo("Java use a Cabeça!",
                    LocalDate.now(), LocalDate.now().plusDays(5));

            System.out.println("\n Tentando realizar emprestimo do CD Java");
//Novo emprestimo!!!
            biblioIFPB.adicionarEmprestimo("CD java",
                    LocalDate.now(), LocalDate.now().plusDays(5));
        }
}
