package QuestionException2;//Crie um programa que inicialize um array de inteiros com alguns valores
//fixos. Peça ao usuário para digitar um índice. O programa deve tentar
//acessar e imprimir o elemento nesse índice.

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestionException2 {
    public static void main(String[] args) {
        int[] numeros = {100, 20, 32, 45, 59 , 80 , 23 , 10};
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um índice que esteja entre 0 e " + (numeros.length - 1) + ": ");

        try {
            int indice = sc.nextInt();
            System.out.println("Valor no índice " + indice + ": " + numeros[indice]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Indice não pertence a lista.");
        } catch (InputMismatchException e) {
            System.out.println("Valor não reconhecido, Deve ser digitado um número inteiro, Rode outra vez.");
        }
    }
}
