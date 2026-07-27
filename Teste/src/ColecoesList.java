import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ColecoesList {


    public static void main(String[] args) {


        List<String> strings = new ArrayList<String>();
        strings.add("Maurício");
        strings.add("José");
        strings.add("Carol");

        System.out.println(strings);
    }

}
//add( int, Object)
// Adiciona um objeto no índice especificado
// add( Object )
// Adiciona um objeto na última posição da lista
// get( int )
// Pega o objeto que estiver na posição passada como parâmetro da
//lista
// size()
// Diz a quantidade de itens que existem na lista
// remove( Object )
// Remove o objeto passado como parâmetro da lista;
// indexOf( Object )
// Diz o índice no qual o objeto passado como parâmetro se encontra,
//ou -1 se ele não estiver na lista;


//Em java existem dois tipos de laço for, um especial para
//
//coleções e arrays (comumente referenciado como for-
//each) e o for comum vindo da linguagem c;
//
// O for-each só é utilizado para navegar em uma coleção
//de objetos;
//
// O for comum pode ser utilizado para qualquer caso de
//laço, mas ele deve ser utilizado apenas quando for um
//caso de “contagem” e não de condição, se o laço é apenas
//condicional, um while pode ser a melhor opção;