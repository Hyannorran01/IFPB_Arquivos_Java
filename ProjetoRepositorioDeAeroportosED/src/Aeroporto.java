import java.util.Objects;

public class Aeroporto implements Comparable<Aeroporto> {
    String codigoID = "inicio";
    String nomeExtenso;

//Construtor
    public Aeroporto(String codigoID, String nomeExtenso) {
        this.codigoID = codigoID;
        this.nomeExtenso = nomeExtenso;
    }
//EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return codigoID == aeroporto.codigoID;
    }
    //HASH-CODE
    @Override
    public int hashCode() {
        return Objects.hashCode(codigoID);
    }

    //GETERS E SETTERS
    public String getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(String codigoID) {
        this.codigoID = codigoID;
    }

    public String getNomeExtenso() {
        return nomeExtenso;
    }

    public void setNomeExtenso(String nomeExtenso) {
        this.nomeExtenso = nomeExtenso;
    }
//TO STRING
    @Override
    public String toString() {
        return "Aeroporto{" +
                "ID: " + codigoID +
                ", nome por extenso: " + nomeExtenso + '\'' +
                '}';
    }

    @Override
    public int compareTo(Aeroporto outra) {
        return codigoID.compareTo(outra.getCodigoID());
    }
//COMPARE TOO do TREE-SET


}
//COMPARE TOO do TREE-SET
//@Override
//public int compareTo(Aeroporto outro) {
//    return Integer.compare(codigoID , outro.codigoID);
