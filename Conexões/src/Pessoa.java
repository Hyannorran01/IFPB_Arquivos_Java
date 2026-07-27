public class Pessoa {

    private String RG;
    private String nome;
    private String CPF;

    public Pessoa() {
    }

    public Pessoa(String RG, String nome, String CPF) {
        this.RG = RG;
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "RG='" + RG + '\'' +
                ", nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
