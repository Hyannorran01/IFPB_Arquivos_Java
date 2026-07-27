import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;


    public Emprestimo(Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        if (livro.isDisponivel() == false){
            System.out.println("O livro não está disponível para a venda");
        }
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public void exibirDetalhesEmprestimo(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd - MM - yyyy");
        System.out.println("Livro: "+ livro.getTitulo());
        System.out.println("Data do Emprestimo: " + dtf.format(dataEmprestimo));
        System.out.println("Data de deevolução: " +  dtf.format(dataDevolucao));
    }

    public void DevoluçãoData(Emprestimo emprestimo){
        if (emprestimo.dataDevolucao.isBefore(emprestimo.dataEmprestimo)){
            System.out.println("Não é possível devolver um emprestimo antes da data de sua realização");
        }


        if (emprestimo.dataDevolucao.isAfter(dataDevolucao.plusDays(5))){
            System.out.println("Data ultrapassou o limite minimo, será adicionada multa pelo tempo de atraso");
            double NovoValor = tempoDeAtraso(emprestimo.livro , 3);
            System.out.println("O valor do Livro pós atraso será: " + NovoValor);
        }
    }

    public double tempoDeAtraso(Livro l , int dias){
       double multa = dias;
       double Novamulta = (multa*2.4) + l.getValor();
       return Novamulta;
    }



//GET E SETTERS
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
