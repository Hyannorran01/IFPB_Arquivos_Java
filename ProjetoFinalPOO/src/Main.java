import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            Biblioteca b1 = new Biblioteca();
            Livro l1 = new Livro("O menino maluquinho" , "Ziraldo", 1012, LocalDate.of(2020,04,01),20);
            Livro l2 = new Quadrinhos("O Espetacular Homen-Aranha","Stan Lee", 2084,LocalDate.of(1962,8,01),30,"Marvel");
            Manga l3 = new Manga("Mirai Nikki", "Sakae Esuno", 9051, LocalDate.of(2006,01,26),50,"Kadokawa Pictures");
            Quadrinhos l4 = new Quadrinhos("Vel vermelho", "Lony Ristrund", 1040, LocalDate.of(2010,6,8),1,"Columba");

            l1.detalhesDoLivro();
            l2.detalhesDoLivro();
            l3.detalhesDoLivro();
            l4.detalhesDoLivro();

            /*

            //Teste de Metodos.
            l1.DetalhesDoLivro();
            l2.DetalhesDoLivro();
            l3.DetalhesDoLivro();

            l4.descobrindoEditora();

            l3.InformandoDistribuidora();

            b1.cadastrandoNovoLivro(l1);
            b1.cadastrandoNovoLivro(l2);
            b1.cadastrandoNovoLivro(l3);
            b1.cadastrandoNovoLivro(l4);

            b1.exibirLivrosDisponiveis(LocalDate.of(1000,01,01),LocalDate.now());

            b1.EmprestarLivro(2084,LocalDate.of(2024,05,20), LocalDate.of(2024,05,27));
            b1.EmprestarLivro(1040, LocalDate.of(2024,07,19), LocalDate.of(2024,7,28));

            b1.EmprestarLivro(1040,LocalDate.of(2024,06,12), LocalDate.of(2024,06,19));
            b1.EmprestarLivro(1040,LocalDate.of(2024,07,20), LocalDate.of(2024,01,18));

            b1.DevolverLivro(2084,LocalDate.of(2024,07,19));
            b1.DevolverLivro(9051,LocalDate.now());


            b1.exibirLivrosDisponiveis(LocalDate.of(1000,01,01),LocalDate.now());

            b1.exibirEmprestimosFeitos();
            b1.procurandoLivrospeloISBN(1012);


         //TESTE PARA comunicação com Banco de dados SQL.

         ClassJDBC dao = new ClassJDBC();
         dao.adicionaLivro(l1);
         dao.adicionaLivro(l2);
         dao.adicionaLivro(l3);
         dao.adicionaLivro(l4);

            */

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}