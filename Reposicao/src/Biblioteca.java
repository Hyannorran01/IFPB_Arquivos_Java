public class Biblioteca {

    // crtl + shift+ R em uma palavra pode a trocar no texto todo.
    private String titulo;
    private String autor;
    private String anoDePublicação;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoDePublicação() {
        return anoDePublicação;
    }

    public void setAnoDePublicação(String anoDePublicação) {
        this.anoDePublicação = anoDePublicação;
    }

    public void exibirInformações(){

        System.out.println("Informações do Livro da Biblioteca: " +
                "Titulo: '" + titulo + '\'' +
                ", Autor: '" + autor + '\'' +
                ", Ano De Publicaçã: ='" + anoDePublicação + '\'' +
                '}');
    }

    public static void main(String[] args) {
        Biblioteca l1 = new Biblioteca();
        l1.anoDePublicação = "2020";
        l1.autor = "Robert";
        l1.titulo = "Um novo sonho";

        Biblioteca l2 = new Biblioteca();
        l2.anoDePublicação = "2021";
        l2.autor = "Amanda";
        l2.titulo = "Pesadelo sem fim";

        l1.exibirInformações();

        l2.exibirInformações();

    }
}
