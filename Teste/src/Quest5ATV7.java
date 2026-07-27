import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Quest5ATV7 {
    int dia;
    int mes;
    int ano;

    public Quest5ATV7(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static void main(String[] args) {

        Quest5ATV7 m1 = new Quest5ATV7(24, 05, 2024);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a data de nascimento, primeiro informe o dia: ");
        int diadito = sc.nextInt();
        System.out.println("agora informe o mes: ");
        int mesdito = sc.nextInt();
        System.out.println("agora informe o ano: ");
        int anodito = sc.nextInt();

        int datanasc = m1.ano;
        int idade = datanasc - anodito;

        if (mesdito >= m1.mes && diadito <= m1.dia) {
            idade = idade - 1;

            System.out.println("Voce tem: " + idade + " anos");
        } else{
            System.out.println("Voce tem: " + idade + " anos");
        }

    }
//imcompleto


    /////////////////////////////////////////////////////

//Calcula a Idade baseado em java.util.Date

    public static int calculaIdade(java.util.Date dataNasc) {

        Calendar dateOfBirth = new GregorianCalendar();

        dateOfBirth.setTime(dataNasc);


// Cria um objeto calendar com a data atual

        Calendar today = Calendar.getInstance();


// Obtém a idade baseado no ano

        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);


        dateOfBirth.add(Calendar.YEAR, age);


//se a data de hoje é antes da data de Nascimento, então diminui 1(um)

        if (today.before(dateOfBirth)) {

            age--;

        }
        return age;
    }
}








