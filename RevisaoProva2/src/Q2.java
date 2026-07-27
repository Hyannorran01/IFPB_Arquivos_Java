import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        List<Integer> listanumeros = new ArrayList<>();

        int n1 = 20;
        int n2 = 50;
        int n3 = 3;
        int n4 = 80;
        String teste2 = null;


        try {

            listanumeros.add(n1);
            listanumeros.add(n2);
            listanumeros.add(n3);
            listanumeros.add(n4);

            int soma = 0;

            for (Integer numero : listanumeros) {
                soma += numero;
            }
            double media = soma / listanumeros.size();

            System.out.println("A soma dos numeros é: " + soma);
            System.out.println("A media dos numeros é: " + media);



            int teste1 = listanumeros.get(0) + listanumeros.get(7);
            System.out.println("A nova palavra tem: " + teste2.length());


        } catch (IndexOutOfBoundsException x) {
            System.out.println("Não há posição parametrizada");
        }

        try{
            System.out.println("A nova palavra tem: " + teste2.length());
        }
        catch (NullPointerException e){
            System.out.println("A string não foi inicializada.");
        }

    }


}

