import java.util.List;
import java.util.ArrayList;

public class TesteDAO {

    public static void main(String[] args) {
        PessoaDAO dao = new PessoaDAO();


        Pessoa p = new Pessoa();
        p.setNome("Joaquim");
        p.setRG("7777777");
        p.setCPF("77777777777");

        //testando inserção
        dao.adicionaPessoa(p);

        //testando busca
        Pessoa pessoa = dao.buscaPessoa(1);
        System.out.println(pessoa);


        //Teste da lista
        List<Pessoa> listaDePessoas = dao.listarPessoas();
        for(Pessoa pes : listaDePessoas){
            System.out.println(pes);
        }

        //Teste Atualização (com Pessoa)
        Pessoa pessoaBuscada = dao.buscaPessoa(2);
        System.out.println("Pessoa Buscada ANTES do Update");
        System.out.println(pessoaBuscada);

        pessoaBuscada.setNome("João Snow");
        dao.atualizarPessoa(pessoaBuscada);

        System.out.println("Pessoa Buscada DEPOIS do Update");
        System.out.println(pessoaBuscada);


        //Teste Atualização (com Pessoa e id)
        Pessoa pessoaBuscadaPeloId = dao.buscaPessoa(3);
        System.out.println("Pessoa BuscadaPeloID ANTES do Update");
        System.out.println(pessoaBuscadaPeloId);

        pessoaBuscadaPeloId.setNome("José da Silva");
        dao.atualizarPessoa(3, pessoaBuscadaPeloId);

        System.out.println("Pessoa pessoaBuscadaPeloId DEPOIS do Update");
        System.out.println(pessoaBuscadaPeloId);



        //testando a exclusão
        int idJoao = 2;
        dao.deletarPessoa(2);
        System.out.println("Excluido com sucesso!!!");



        //Testar a exclusão pelo objeto

        Pessoa buscadaNoBanco = dao.buscaPessoa(3);
        dao.deletarPessoa(buscadaNoBanco);

    }
}
