import javax.swing.*;
import java.util.TreeSet;

public class RepositorioAeroporto {
    TreeSet<Aeroporto> ConjuntoDeAeroportos = new TreeSet<Aeroporto>();


    public boolean cadastrarAeroporto(Aeroporto aeroporto) {
        return ConjuntoDeAeroportos.add(aeroporto);
    }

    public boolean removerAeroporto(Aeroporto aeroporto) {
        return ConjuntoDeAeroportos.remove(aeroporto);
    }

    public boolean existeAeroporto(String codigoID) {
        for (Aeroporto x : ConjuntoDeAeroportos) {
            if (x.codigoID == codigoID) {
                System.out.println("Existe");
                return true;
            }
        }
        System.out.println("Não existe");
        return false;
    }
    public Aeroporto getAeroporto(String codigoID) {
        for (Aeroporto x : ConjuntoDeAeroportos) {
            if (x.codigoID == codigoID) {
                System.out.println("Esse ID está cadastrado, Aeroporto Válido");
                return x;
            }
        }
        System.out.println("Codigo não valido, Aeroporto não cadastrado");
        return null;
    }
}
