//Numa eleição existem três candidatos. Faça um programa que peça o
//número total de eleitores. Peça para cada eleitor votar e ao final mostrar o
//número de votos de cada candidato.


import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalEleitores;
        int votosCandidatoA = 0;
        int votosCandidatoB = 0;
        int votosCandidatoC = 0;

        System.out.println("Vamos começar a eleição, Realizem seus votos: (Votar em A digite 1, votar em B digite 2, Votar em C digite 3) ");

        System.out.print("Digite o número total de eleitores: ");
        totalEleitores = scan.nextInt();

        for (int i = 1; i <= totalEleitores; i++) {
            int voto;
            do {
                System.out.print("Eleitor " + i + ", realize seu voto: ");
                voto = scan.nextInt();

                if (voto < 1 || voto > 3) {
                    System.out.println("Voto inválido! Tente novamente.");
                }
            } while (voto < 1 || voto > 3);

            if (voto == 1) {
                votosCandidatoA++;
            } else if (voto == 2) {
                votosCandidatoB++;
            } else {
                votosCandidatoC++;
            }
        }
        System.out.println("O Candidato A teve: " + votosCandidatoA + " voto(s)");
        System.out.println("O Candidato B teve: " + votosCandidatoB + " voto(s)");
        System.out.println("O Candidato C teve: " + votosCandidatoC + " voto(s)");

    }
}
