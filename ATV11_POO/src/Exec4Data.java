import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exec4Data {
    public static void main(String[] args) {
        LocalDate dataDia = LocalDate.now();

        System.out.println("Data de hoje: " + dataDia);
        System.out.println("Agora padronizando no formato brasileiro: ");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAtualizadaFormat = dataDia.format(formatador);
        System.out.println(dataAtualizadaFormat);

        System.out.println("Aumentando 30 dias: ");
        LocalDate novaData = dataDia.plusDays(30);
        System.out.println(novaData.format(formatador));

        System.out.println("Voltando 2 meses da data anterior: ");
        System.out.println(novaData.minusMonths(2).format(formatador));
    }
}
