import java.util.*;
import java.util.function.Predicate;

public class Q3 <T extends Comparable<T>> {
    List<T> colecao = new ArrayList<>();

    @Override
    public String toString() {
        return "Q3{" +
                "colecao=" + colecao +
                '}';
    }

    public void adicao(T generico){
        colecao.add(generico);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Q3<?> q3 = (Q3<?>) o;
        return Objects.equals(colecao, q3.colecao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(colecao);
    }

    public List<T> filtrar(Predicate<T> condicao){
        List<T> associacaoFiltro = new ArrayList<T>();
        for (T elemento : associacaoFiltro){
            if (condicao.test(elemento)){
                associacaoFiltro.add(elemento);
            }
        }
        return associacaoFiltro;
    }

    public void ordenar(){

            Collections.sort(colecao);

    }

    Predicate<Integer> numerointeiroPositivo = elemento -> elemento > 0;
    Predicate<String> começacomBe = elemento -> elemento.startsWith("Be");

    public static void main(String[] args) {
        Q3<String> teste1 = new Q3<>();
        teste1.adicao("Beto");
        teste1.adicao("Mario");
        teste1.adicao("Bia");
        teste1.adicao("Ronaldo");

        Q3<Integer> teste4 = new Q3<>();

        teste4.adicao(10);
        teste4.adicao(20);
        teste4.adicao(-5);

        teste4.ordenar();
        teste1.ordenar();


        teste1.filtrar(elemento -> elemento.startsWith("B"));
        teste4.filtrar(elemento -> elemento>0);




    }




}
