import java.io.IOException;

public class TestarApp {
    public static void main(String[] args) throws IOException {
        RepositorioLivros x = new RepositorioLivros();
        x.criarRepositorio();

        System.out.println("Após a criação automática do Conjunto e da lista vamos criar 2 manualmente e conferir no depurador se entrou ordenado");
        System.out.println("Adicionando um novo livro: ");
        Livros l1 = new Livros(800 , "O pequeno Principe" , "Antonie de Saint-Exupery" ,"ebook", 19.90);
        x.cadastrarLivro(l1);
        System.out.println("Adicionando outro livro: ");
        Livros l2 = new Livros(100000 , "Harry Potter" , "J.K.Rowling" ,"paperback", 149.90);
        x.cadastrarLivro(l2);
        System.out.println("Removendo o livro: ");
        x.removerLivro(l1);
        System.out.println("Sucesso.");

        System.out.println("Buscando Codigo de livro para saber... o codigo '12' está na lista? ");
        System.out.println(x.livroExiste(12));
        System.out.println("Buscando por um codigo de livro que não está na lista: ");
        System.out.println(x.livroExiste(1000));
        System.out.println("Buscando por um codigo de livro para saber qual livro pertence ");
        System.out.println(x.getLivro(71));

        System.out.println("Ordenando pelo Autor: ");
        x.ordenarporAutor();
        System.out.println("Ordenando pelo Preço: ");
        x.ordenarporPreco();
        System.out.println("Ordenando pelo Titulo: ");
        x.ordenarporTitulo();

        System.out.println("Todos os testes foram concluídos com exito, finalizando programa.");
    }
}
