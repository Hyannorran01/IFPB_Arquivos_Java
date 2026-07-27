import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma data no formato americano: ");
        String x = scanner.next();
        System.out.println("Data gerada: " + x);

        DateTimeFormatter base = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate baseData = LocalDate.parse(x,base);

            DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String DataFormatada2 = baseData.format(formatador2);
            System.out.println("Primeira formatação: " + DataFormatada2);

            DateTimeFormatter formatador1 = DateTimeFormatter.ofPattern("MM dd,yyyy");
            String novaData = baseData.format(formatador1);
            System.out.println("Segunda Formatacao: " + novaData);

        }catch (DateTimeParseException d){
            System.out.println("Erro de Formatação");
        }
    }
}
