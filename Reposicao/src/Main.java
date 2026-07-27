import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long chute = 0;
        Random R1 = new Random();
        int numerosecreto = R1.nextInt(0,100);

        System.out.println("Digite um numero: ");
        chute = sc.nextLong();


        if (chute >= 0 && chute <= 100) {
            if (numerosecreto == chute){
                System.out.println("Você Acertou");
            }

            if (numerosecreto > chute){
                System.out.println("Palpitou baixo");
            }

            if (numerosecreto < chute){
                System.out.println("Palpitou alto");
            }

        }
        else
            System.out.println("Seu numero é invalido, favor digitar dentro do limite 0 a 100");
    }

}