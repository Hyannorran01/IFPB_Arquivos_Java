import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int somaPares = 0;
        int pares = 0;
        int somaTotal = 0;
        int contadorTotal = 0;
        int impares = 0;

        System.out.println("Testando os Números: ");

        while (true) {
            numero = sc.nextInt();
            if (numero == 0) {
                break;
            }
            somaTotal += numero;
            contadorTotal++;

            if (numero % 2 == 0) {
                somaPares += numero;
                pares++;
            } else {
                impares++;
            }
        }
        double mediaPares = (double) somaPares / pares;
        double mediaGeral = (double) somaTotal / contadorTotal;

        System.out.println("Resultados: ");
        System.out.println("Quantidade de números pares: " + pares);
        System.out.println("Quantidade de números ímpares: " + impares);
        System.out.println("Média dos valores pares: " + mediaPares);
        System.out.println("Média geral: " + mediaGeral);
        sc.close();
    }
}