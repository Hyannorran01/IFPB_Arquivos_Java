
enum MesesDoAno{
    JANEIRO("31") ,
    FEVEREIRO("28"),
    MARCO("31"),
    ABRIL("30"),
    MAIO("31"),
    JUNHO("30"),
    JULHO("31"),
    AGOSTO("31"),
    SETEMBRO("30"),
    OUTUBRO("31"),
    NOVEMBRO("30"),
    DEZEMBRO("31");

    String Diadoano;

    MesesDoAno(String diadoano){
        this.Diadoano = diadoano;
    }

    String getQuantidadeDias(){
        return Diadoano;
    }

    @Override
    public String toString() {
        return getQuantidadeDias();
    }
}

public class Q4 {

    }

class TesteAPP {
    private MesesDoAno mes;
    public TesteAPP() {

    }

    public TesteAPP(MesesDoAno mes){
        this.setMes(mes);
    }

    @Override
    public String toString() {
        return "TesteAPP{" +
                "mes=" + getMes() +
                '}';
    }

    public void TestarMes(MesesDoAno m) throws IllegalArgumentException {
        if (m.equals(MesesDoAno.JANEIRO)
                || m.equals(MesesDoAno.FEVEREIRO)
                || m.equals(MesesDoAno.MARCO)
                || m.equals(MesesDoAno.ABRIL)
                || m.equals(MesesDoAno.MAIO)
                || m.equals(MesesDoAno.JUNHO)
                || m.equals(MesesDoAno.JULHO)
                || m.equals(MesesDoAno.AGOSTO)
                || m.equals(MesesDoAno.SETEMBRO)
                || m.equals(MesesDoAno.OUTUBRO)
                || m.equals(MesesDoAno.NOVEMBRO)
                || m.equals(MesesDoAno.DEZEMBRO) ) {
            System.out.println("Mes Valido");
        }
        else{
            throw new IllegalArgumentException();
        }
    }



    public static void main(String[] args) throws IllegalArgumentException {
        try {
            TesteAPP x = new TesteAPP();
            TesteAPP y = new TesteAPP(MesesDoAno.ABRIL);

            System.out.println("Esse mês possui: " + y.getMes().getQuantidadeDias() + " Dias");
            y.TestarMes(y.getMes());
            //x.setMes(MesesDoAno.valueOf("PORTUGUES")); > Vai disparar excessão de Mes invalido se for alterar para um que não existe.

            x.setMes(MesesDoAno.valueOf("JANEIRO"));
            x.TestarMes(x.getMes());

            System.out.println("Esse mês possui: " + x.getMes().getQuantidadeDias() + " Dias");
        }catch (IllegalArgumentException e){
            System.out.println("Valor de Mês indevido");
        }catch (NullPointerException nullEnum){
            System.out.println(("Valor do mês não repassado"));
        }
    }

    public MesesDoAno getMes() {
        return mes;
    }

    public void setMes(MesesDoAno mes) {
        this.mes = mes;
    }
}

