import java.util.Objects;

public class Aeroporto implements Comparable<Aeroporto> {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return Objects.equals(código, aeroporto.código) &&
        Objects.equals(nome, aeroporto.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(código, nome);
    }
    @Override
    public int compareTo(Aeroporto o){
        return this.código.compareTo(o.código);
    }
    String código;
    String nome;
    public Aeroporto(String código, String nome) {
        this.código = código;
        this.nome = nome;
    }
    public String getCódigo() {
        return código;
    }
    public void setCódigo(String código) {
        this.código = código;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "código='" + código + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
