public class Livro {
    private String titulo;
    private int ID;
    private double valor;
    private boolean disponivel = true;

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public Livro(String titulo, boolean disponivel) {
        this.titulo = titulo;
        this.disponivel = disponivel;
    }

    public Livro(String titulo, int ID, double valor, boolean disponivel) {
        this.titulo = titulo;
        this.ID = ID;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponivel(){
        return disponivel;
    }




    public void devolver(){
        disponivel=true;
    }

    public void emprestar() throws LivroIndisponivelException {
        if(!disponivel){
            throw new LivroIndisponivelException("O livro" + getTitulo() + "Não está disponível");
        }
        disponivel = false;
    }
}
