import java.util.Objects;

public class Livros implements Comparable<Livros>{
    int cod_livro;
    String titulo_extendido;
    String autor_livro;
    String tipo_do_livro;
    double preco;

//Construtor para Novos livros por Instancia
    public Livros(int cod_livro, String titulo_extendido, String autor_livro, String tipo_do_livro, double preco) {
        this.cod_livro = cod_livro;
        this.titulo_extendido = titulo_extendido;
        this.autor_livro = autor_livro;
        this.tipo_do_livro = tipo_do_livro;
        this.preco = preco;
    }
//Construtor para leitor de linhas do arquivo.
    public Livros(String parte, String parte1, String parte2, String parte3, String parte4) {
        this.cod_livro = Integer.parseInt(parte);
        this.titulo_extendido = parte1;
        this.autor_livro = parte2;
        this.tipo_do_livro = parte3;
        this.preco = Double.parseDouble(parte4);
    }


    //Comparador Principal Tree-set

    @Override
    public int compareTo(Livros outro) {
        return Integer.compare(cod_livro,outro.getCod_livro());
    }


    //Hashcode e Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return Objects.equals(cod_livro, livros.cod_livro) && Objects.equals(titulo_extendido, livros.titulo_extendido) && Objects.equals(autor_livro, livros.autor_livro) && Objects.equals(tipo_do_livro, livros.tipo_do_livro) && Objects.equals(preco, livros.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_livro, titulo_extendido, autor_livro, tipo_do_livro, preco);
    }

    //GET E SET
    public int getCod_livro() {
        return cod_livro;
    }

    public int setCod_livro(int cod_livro) {
        this.cod_livro = cod_livro;
        return cod_livro;
    }

    public String getTitulo_extendido() {
        return titulo_extendido;
    }

    public void setTitulo_extendido(String titulo_extendido) {
        this.titulo_extendido = titulo_extendido;
    }

    public String getAutor_livro() {
        return autor_livro;
    }

    public void setAutor_livro(String autor_livro) {
        this.autor_livro = autor_livro;
    }

    public String getTipo_do_livro() {
        return tipo_do_livro;
    }

    public void setTipo_do_livro(String tipo_do_livro) {
        this.tipo_do_livro = tipo_do_livro;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //TO STRING PARA NOMEAR MELHOR NA SAIDA.
    @Override
    public String toString() {
        return "Livros{" +
                "cod_livro=" + cod_livro +
                ", titulo_extendido='" + titulo_extendido + '\'' +
                ", autor_livro='" + autor_livro + '\'' +
                ", tipo_do_livro='" + tipo_do_livro + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}