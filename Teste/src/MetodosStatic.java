import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

///Todos os nomes de métodos, variáveis de instância, locais
//ou estáticas devem ser escritos com a primeira letra em
//minúsculo, se o nome for composto por mais do que
//uma palavra, a primeira letra da nova palavra deve ser
//escrita com maiúsculo;

public class MetodosStatic {



    public static SimpleDateFormat format =
            new SimpleDateFormat("dd/MM/yyyy");

    public static void imprimirData( Date data ) {
        System.out.println( format.format( data ) );
    }

    public static void main(String[] args) {



        // Testando comparativos

        System.out.println( 1 == 2 );
        System.out.println( 'z' != 'a' );
        System.out.println( 8 > 10 );
        System.out.println( 5 >= 5 );
        System.out.println( "Testes: " + ("abc" == "bcd") );

    }
}
