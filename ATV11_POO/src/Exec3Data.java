import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exec3Data {
    public static void main(String[] args) {
        LocalDate dataHoje = LocalDate.now();
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma data comun para ser formatada, primeiro diga o ano completo: ");
        int dataEspecifica1 = scan.nextInt();
        System.out.println("Agora o mês em numero: ");
        int dataEspecifica2= scan.nextInt();
        System.out.println("Agora o dia: ");
        int dataEspecifica3= scan.nextInt();

        LocalDate dataarmazenada = LocalDate.of(dataEspecifica1,dataEspecifica2,dataEspecifica3);

        System.out.println("Agora vamos ver a data de hoje em um novo formato: ");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataformatada = dataarmazenada.format(formatador);
        System.out.println("a data formatada ficou: " + dataformatada);
        System.out.println("Agora vamos ver a data de hoje formatada: ");

        String dataformatadaHoje = dataHoje.format(formatador);
        System.out.println("a data de hoje formatada ficou: " + dataformatadaHoje);

        System.out.println("Data de hoje em formato Norte americano é: ");

        System.out.println(dataHoje);
    }
}
