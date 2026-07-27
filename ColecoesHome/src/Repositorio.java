import java.util.TreeSet;

public class Repositorio {String código;
    TreeSet<Aeroporto>aeroportos = new TreeSet<>();
    public Repositorio(String código) {
        this.código = código;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "código='" + código + '\'' +
                '}';
    }

    public void adicionarAeroporto (Aeroporto aeroporto){
        aeroportos.add(aeroporto);
    }
    public void removerAeroporto (Aeroporto aeroporto){
        aeroportos.remove(aeroporto);
    }
    public boolean buscarAeroporto(Aeroporto aeroporto){
        return aeroportos.contains(aeroporto);
    }
}

