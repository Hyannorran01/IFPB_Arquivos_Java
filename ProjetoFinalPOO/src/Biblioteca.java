import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class LivroEmprestadoException extends Exception{
    public LivroEmprestadoException(String mensagemdoerro){
        super(mensagemdoerro);
    }
}

class QuantidadeInvalidaException extends Exception{
    public QuantidadeInvalidaException(String erro){
        super(erro);
    }
}

class Livro{
    private String titulo;
    private String autor;
    private int ISBN;
    private LocalDate anoDePublicacao;
    private int QCopias;

    public String getTitulo() {
        return titulo;
    }

    public String getTitulo(String titulo) {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAutor(String autor) {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getISBN(int ISBN) {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public LocalDate getAnoDePublicacao(LocalDate anoDePublicacao) {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(LocalDate anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public int getQCopias() {
        return QCopias;
    }

    public int getQCopias(int QCopias) {
        return QCopias;
    }

    public void setQCopias(int QCopias) {
        this.QCopias = QCopias;
    }

    public Livro(String titulo, String autor, int ISBN, LocalDate anoDePublicacao, int QCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.anoDePublicacao = anoDePublicacao;
        this.QCopias = QCopias;
    }

    public void emprestado() throws QuantidadeInvalidaException {
        int quantidadeAtual = getQCopias();
        if (quantidadeAtual == 0){
            throw new QuantidadeInvalidaException("Não há mais copias disponiveis para serem emprestadas");
        }
        int quantidadeNova = quantidadeAtual-1;
        System.out.println("1 livro foi emprestado. A quantidade de copias foi atualizada para: " + quantidadeNova);
    }

    public void devolvido() {
        int quantidadeAtual = getQCopias();
        int quantidadeNova = quantidadeAtual+1;
        System.out.println("1 livro foi devolvido. A quantidade de copias foi atualizada para: " + quantidadeNova);
    }

    public void detalhesDoLivro(){
        System.out.println(toString());
    }

    public Livro() { }

    @Override
    public String toString() {
        return "Livro (" +
                "Titulo do Livro: '" + titulo + '\'' +
                ", Autor/Escritor: '" + autor + '\'' +
                ", Identificador: " + ISBN +
                ", Ano que foi Publicado: " + anoDePublicacao +
                ", Copias Disponíveis: " + QCopias +
                ')';
    }
}

class Quadrinhos extends Livro{
    private String editora;

    public Quadrinhos(String titulo, String autor, int ISBN, LocalDate anoDePublicacao, int QCopias, String editora) {
        super(titulo, autor, ISBN, anoDePublicacao, QCopias);
        this.editora = editora;
    }

    public void descobrindoEditora() {
        System.out.println("A editora é: " + editora);
    }
}

class Manga extends Livro{
    private String distribuidora;

    public Manga(String titulo, String autor, int ISBN, LocalDate anoDePublicacao, int QCopias, String distribuidora) {
        super(titulo, autor, ISBN, anoDePublicacao, QCopias);
        this.distribuidora = distribuidora;
    }


    public void InformandoDistribuidora(){
        System.out.println("Distribuidora: " + distribuidora);
    }
}


class Emprestimo{
    private Livro livroEmprestado;
    LocalDate inicioDoEmprestimo;
    LocalDate fimDoEmprestimo;

    public Emprestimo(Livro livroEmprestado, LocalDate inicioDoEmprestimo, LocalDate fimDoEmprestimo) throws QuantidadeInvalidaException {
        if (livroEmprestado.getQCopias() == 0){
            throw new QuantidadeInvalidaException("O livro não tem copias");
        }
        this.livroEmprestado = livroEmprestado;
        this.inicioDoEmprestimo = inicioDoEmprestimo;
        this.fimDoEmprestimo = fimDoEmprestimo;

        System.out.println("O Emprestimo do livro: " + getLivroEmprestado().getTitulo() + " Foi realizado com sucesso.");
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public LocalDate getInicioDoEmprestimo() {
        return inicioDoEmprestimo;
    }

    public LocalDate getFimDoEmprestimo() {
        return fimDoEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimos(" +
                "livroEmprestado: " + livroEmprestado.getTitulo() +
                ", Data do Emprestimo: " + inicioDoEmprestimo +
                ", Data para Devolução: " + fimDoEmprestimo +
                ')';
    }
}


public class Biblioteca {
    private Map<Integer, Livro> livros = new HashMap<>();
    private Map<Integer, Emprestimo> emprestimos = new HashMap<>();

    public void cadastrandoNovoLivro(Livro livro) {
        livros.putIfAbsent(livro.getISBN(), livro);
    }

    public void EmprestarLivro(int codigoISBN, LocalDate inicioDoEmprestimo, LocalDate finalDoEmprestimo) throws LivroEmprestadoException, QuantidadeInvalidaException {
        if (!livroDisponivel(codigoISBN, inicioDoEmprestimo, finalDoEmprestimo) || livros.get(codigoISBN).getQCopias() == 0) {
            throw new LivroEmprestadoException("Ops, O livro está emprestado no momento e não há mais exemplares.");
        }
        Livro livro = livros.get(codigoISBN);
        Emprestimo empr = new Emprestimo(livro, inicioDoEmprestimo, finalDoEmprestimo);
        emprestimos.put(codigoISBN, empr);
        livro.emprestado();
        livro.setQCopias(livro.getQCopias() - 1);
    }

    public void DevolverLivro(int CodigoISBN, LocalDate inicioDoEmprestimo) {
        Livro livro = livros.get(CodigoISBN);
        if (emprestimos.containsKey(CodigoISBN)) {
            emprestimos.remove(CodigoISBN, inicioDoEmprestimo);
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            livro.devolvido();
            livro.setQCopias(livro.getQCopias() + 1);
            System.out.println("O livro de codigo: " + CodigoISBN + " Emprestado em: " + inicioDoEmprestimo.format(formatador) + " Foi removido da lista de emprestimos pois já foi devolvido");
        } else
            System.out.println("Livro não consta como emprestado");
    }

    private boolean livroDisponivel(int ISBN, LocalDate inicioDoEmprestimo, LocalDate finalDoEmprestimo) {
        Emprestimo emprestimo = emprestimos.get(ISBN);
        if (emprestimo == null) {
            return true;
        }
        return finalDoEmprestimo.isBefore(emprestimo.getInicioDoEmprestimo()) || inicioDoEmprestimo.isAfter(emprestimo.getFimDoEmprestimo());
    }

    public void exibirLivrosDisponiveis(LocalDate dataInicio, LocalDate dataFim) {
        for (Livro livro : livros.values()) {
            if (livroDisponivel(livro.getISBN(), dataInicio, dataFim)) {
                System.out.println(livro);
            }
        }
    }

    public void procurandoLivrospeloISBN(int ISBN) {
            if (!livros.containsKey(ISBN)) {
                System.out.println("Codigo não localizado");
            }else
                System.out.println(livros.get(ISBN));
    }

    public void exibirEmprestimosFeitos(){
        for (Emprestimo emp : emprestimos.values()){
            System.out.println(emp);
        }
    }
}

//-----------------------------------Classe Main------------------------------------------//
class Teste{
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
//--------------------------------------CLASSE JDBC para SQL-----------------------------//
class ClassJDBC {
    private Connection con;

    public ClassJDBC(){
        String url = "jdbc:mysql://localhost:3307/biblioteca";
        String user = "root";
        String password = "";
        try{
            con = DriverManager.getConnection(url, user, password);
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Erro ao conectar");
        }
    }

    public void adicionaLivro(Livro livro){
        try{
            String consulta = "INSERT INTO livros (titulo , autor , ISBN , Ano_Publicacao, Copias)" +
                    " VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setInt(3, livro.getISBN());
            ps.setDate(4, Date.valueOf(livro.getAnoDePublicacao()));
            ps.setInt(5,livro.getQCopias());
            ps.executeUpdate();
            ps.close();
        }catch (Exception ex){
            System.out.println("Erro ao inserir");
            ex.printStackTrace();
        }
    }

    public Livro buscaPessoa(int id) {
        Livro l = null;
        try {
            String query = "Select * from pessoas where id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                l = new Livro();
                l.getTitulo(rs.getString("titulo"));
                l.getAutor(rs.getString("autor"));
                l.getISBN(rs.getInt("ISBN"));
                l.getAnoDePublicacao(rs.getDate("Ano_Publicacao").toLocalDate());
                l.getQCopias(rs.getInt("Copias"));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return l;
    }

    public List<Livro> listarLivros(){
        List<Livro> livros = new ArrayList<Livro>();
        try{
            String query = "select * from livros";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Livro livro = new Livro();
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setISBN(rs.getInt("ISBN"));
                livro.setAnoDePublicacao(rs.getDate("Ano_Publicacao").toLocalDate());
                livro.setQCopias(rs.getInt("Copias"));
                livros.add(livro);
            }
            rs.close();
            ps.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return livros;
    }

    public void atualizarLivro(Livro livro){
        try{
            String query = "UPDATE livros SET titulo=?, autor=?, ISBN=? , Ano_Publicacao=?, Copias=? where ISBN=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setInt(3, livro.getISBN());
            ps.setDate(4, Date.valueOf(livro.getAnoDePublicacao()));
            ps.setInt(5,livro.getQCopias());
            ps.setInt(6, livro.getISBN());
            ps.executeUpdate();

        }catch (Exception ex){
            System.out.println("Chave Primária não localizada");
            ex.printStackTrace();
        }
    }

    public void atualizarLivro(int id, Livro livro){
        try{
            String query = "UPDATE livros SET titulo=?, autor=?, ISBN=? , Ano_Publicacao=?, Copias=? where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setInt(3, livro.getISBN());
            ps.setDate(4, Date.valueOf(livro.getAnoDePublicacao()));
            ps.setInt(5,livro.getQCopias());
            ps.setInt(6, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println("Atualização não realizada, ID inconsistente");
            ex.printStackTrace();
        }
    }

    public void deletarLivro(int id){
        try{
            String query = "delete from livros where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);

            ps.executeUpdate();
            ps.close();

        }catch(Exception ex){
            System.out.println("ID não localizada");
            ex.printStackTrace();
        }
    }

    public void deletarLivro(Livro livro){
        try{
            String query = "delete from livros where ISBN=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, livro.getISBN());
            ps.executeUpdate();
            ps.close();

        }catch(Exception ex){
            System.out.println("Codigo não valido.");
            ex.printStackTrace();
        }
    }
}
