import java.util.ArrayList;

public class GerenciadorTarefas {
    ArrayList<Tarefas> Listagem = new ArrayList<>();

    public void adicionartarefas(Tarefas tarefas) {
        Listagem.add(tarefas);

    }

    public void removertarefas(Tarefas tarefas) {

        Listagem.remove(tarefas);
    }

    @Override
    public String toString() {
        return "ListadeTarefas{" +
                "Listagem=" + Listagem +
                '}';
    }

    public void listar() {
        for (Tarefas tarefas : Listagem)
            System.out.println("Na nossa lista temos a tarefa: " + tarefas.Descricao + " E o seu Status é: " + tarefas.Status);
    }



    public static class Tarefas {
        String Descricao;
        String Status;

        public Tarefas(String descricao, String status) {
            Descricao = descricao;
            Status = status;
        }

    }




    public static void main(String[] args) {

        GerenciadorTarefas lista = new GerenciadorTarefas();

        Tarefas t1 = new Tarefas(" Arrumar o quarto ", " Concluido");
        Tarefas t2 = new Tarefas(" Organizar o Guarda Roupa ", " Concluido ");
        Tarefas t3 = new Tarefas(" Limpar as janelas ", " Não concluido ");

        lista.adicionartarefas(t1);
        lista.adicionartarefas(t2);
        lista.adicionartarefas(t3);


        lista.listar();

        lista.removertarefas(t2);
        lista.removertarefas(t3);

        System.out.println("Atualizando: ");
        lista.listar();

    }
}
