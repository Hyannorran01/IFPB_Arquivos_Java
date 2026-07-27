import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class RepositorioLivros {


    TreeSet<Livros> repositorio_biblioteca = new TreeSet<>();
    List<String> listandoArquivo = Files.readAllLines(Path.of("src/dados/livros.txt"));
    public RepositorioLivros() throws IOException {
    }

    void criarRepositorio(){
        for (String cadaLinha : listandoArquivo) {
            String[] partes = cadaLinha.split(";");
            Livros novo = new Livros(partes[0], partes[1], partes[2], partes[3], partes[4]);
            repositorio_biblioteca.add(novo);
        }
    }

    void cadastrarLivro(Livros novoLivro){
        repositorio_biblioteca.add(novoLivro);
    }

    boolean removerLivro(Livros livro_descartado){
        return repositorio_biblioteca.remove(livro_descartado);
    }
    boolean livroExiste(int codigoDoLivroProcurado){
        for (Livros x : repositorio_biblioteca) {
            if (x.cod_livro == codigoDoLivroProcurado){
                System.out.println("Livro Localizado! Ele existe");
                return true;
            }
        }
        System.out.println("Livro não existe");
        return false;
    }

    public Livros getLivro(int codLivro){
        for (Livros obj : repositorio_biblioteca) {
            if (obj.cod_livro == codLivro){
                System.out.println("codigo foi validado, o Livro buscado é: ");
                return obj;
            }
        }
        System.out.println("Codigo inexistente");
        return null;
    }

    //Metodos de ordenação por outros atributos

    void ordenarporTitulo(){
        Comparator<Livros> ordemTitulo = Comparator.comparing(Livros::getTitulo_extendido);
        repositorio_biblioteca.stream().sorted(ordemTitulo).forEach(System.out::println);

    }

    void ordenarporAutor(){
        Comparator<Livros> ordemAutor = Comparator.comparing(Livros::getAutor_livro);
        repositorio_biblioteca.stream().sorted(ordemAutor).forEach(System.out::println);

    }

    void ordenarporPreco(){
        Comparator<Livros> ordemPreco = Comparator.comparingDouble(Livros::getPreco);
        repositorio_biblioteca.stream().sorted(ordemPreco).forEach(System.out::println);

    }


}

