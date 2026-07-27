import java.time.LocalDate;
import java.util.TreeMap;

class salaReservadaException extends Exception {
    public salaReservadaException(String mensagem) {
        super(mensagem);
    }
}
class Lista {
    TreeMap<LocalDate, String> AssociadorMap = new TreeMap<>();

    public void Reservar(LocalDate x, String y) throws salaReservadaException {
        if (AssociadorMap.containsKey(x)) {
            throw new salaReservadaException("Esse horário já está reservado");
        }
        AssociadorMap.put(x, y);
        System.out.println("Sala reservada no horário");
    }
}
public class Q7 {
    LocalDate dataGuardada;
    String nomeDaSala;

    public Q7(String nomeDaSala, LocalDate dataGuardada) {
        this.nomeDaSala = nomeDaSala;
        this.dataGuardada = dataGuardada;
    }

    @Override
    public String toString() {
        return "Q7{" +
                "dataGuardada=" + dataGuardada +
                ", nomeDaSala='" + nomeDaSala + '\'' +
                '}';
    }
}
class Central {
    public static void main(String[] args) {
        Lista listadeReservas = new Lista();
        try {
            Q7 p1 = new Q7("Sala de Artes", LocalDate.of(2024, 02, 13));
            Q7 p2 = new Q7("Sala de Cinema", LocalDate.of(2024, 02, 13));
            System.out.println(p1);
            System.out.println(p2);

            listadeReservas.Reservar(p1.dataGuardada, p1.nomeDaSala);
            listadeReservas.Reservar(p2.dataGuardada, p2.nomeDaSala);

        } catch (salaReservadaException s) {
            System.out.println(s.getMessage());
        }
    }
}
