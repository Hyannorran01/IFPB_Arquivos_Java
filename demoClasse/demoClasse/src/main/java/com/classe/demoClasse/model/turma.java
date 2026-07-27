public class turma {

    private String nome;
    private int Id;

    public turma(String nome, int id) {
        this.nome = nome;
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}