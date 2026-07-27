//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        RepositorioAeroporto repositorioAeroporto = new RepositorioAeroporto();
        Aeroporto a1 = new Aeroporto("AUS" , "Austin Robert Mueller Municipal");
        Aeroporto a2 = new Aeroporto("CPR" , " Casper/Natrone County International");
        Aeroporto a3 = new Aeroporto("ABE", "Allentown - Bethlehem - Easton International");
        Aeroporto a4 = new Aeroporto("PHL" , "Philadelphia International");
        Aeroporto a5 = new Aeroporto("BIS ", "Bismarck Municipal");
        Aeroporto a6 = new Aeroporto("MDW" , "Chicago Midway");
        Aeroporto a7 = new Aeroporto("YYZ" , "Lester B.Pearson International(Toronto)");
        Aeroporto a8 = new Aeroporto("SAT" , "San Antonio International");
        Aeroporto a9 = new Aeroporto("LAX" , "Los Angeles International");
        Aeroporto a10 = new Aeroporto("FAT" , "Fresno Air Terminal");

        repositorioAeroporto.cadastrarAeroporto(a1);
        repositorioAeroporto.cadastrarAeroporto(a2);
        repositorioAeroporto.cadastrarAeroporto(a3);
        repositorioAeroporto.cadastrarAeroporto(a4);
        repositorioAeroporto.cadastrarAeroporto(a5);
        repositorioAeroporto.cadastrarAeroporto(a6);
        repositorioAeroporto.cadastrarAeroporto(a7);
        repositorioAeroporto.cadastrarAeroporto(a8);
        repositorioAeroporto.cadastrarAeroporto(a9);
        repositorioAeroporto.cadastrarAeroporto(a10);

        repositorioAeroporto.removerAeroporto(a3);
        System.out.println("Agora vamos saber se o codigo procurado está presente ou existe na lista o 'AUS': ");

        System.out.println("Sobre o repositorio procurado a resposta é: " + repositorioAeroporto.existeAeroporto("AUS"));
        System.out.println("Testando se há uma que nunca foi colocada na lista, o codigo 'BBB': ");
        System.out.println("Sobre o repositorio procurado a resposta é: " + repositorioAeroporto.existeAeroporto("BBB"));

        System.out.println("Agora pelo codigo digitado vamos saber se existe o tal aeroporto pelo codigo passado o codigo 'FAT': ");

        System.out.println(repositorioAeroporto.getAeroporto("FAT"));
        System.out.println("Agora proximo teste com o codigo: 'CCC' .");

        System.out.println("Agora vamos procurar por um codigo não visto: " + repositorioAeroporto.getAeroporto("CCC"));

        


    }
}