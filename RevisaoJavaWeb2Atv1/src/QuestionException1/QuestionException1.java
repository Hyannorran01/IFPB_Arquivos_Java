package QuestionException1;//Crie um programa que solicite ao usuário dois números inteiros e realize a
//divisão do primeiro pelo segundo. Garanta que o programa não "quebre" se o
//usuário tentar dividir por zero ou inserir um valor que não seja um número.


import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestionException1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero1, numero2;
        boolean sucesso = false;
        while (!sucesso) {
            try {
                System.out.print("Digite o primeiro número: ");
                numero1 = sc.nextInt();

                System.out.print("Digite o segundo número: ");
                numero2 = sc.nextInt();

                int resultado = numero1 / numero2;
                System.out.println("Resultado da divisão: " + resultado);
                sucesso = true;
            } catch (ArithmeticException e) {
                System.out.println("Exception: Divisão por zero não é permitida. Tente novamente.");
            } catch (InputMismatchException e) {
                System.out.println("Exception: Esse valor não é um número.");
                sc.nextLine();
            }
        }
    }
}
