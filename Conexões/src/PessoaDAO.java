import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO{
    private Connection con;

    public PessoaDAO(){
        String url = "jdbc:mysql://localhost:3307/agenda";
        String user = "root";
        String password = "";
        try{
            con = DriverManager.getConnection(url, user, password);
        }catch (Exception ex){
           ex.printStackTrace();
            System.out.println("Erro ao conectar");
        }
    }

    //adicionarPessoa
    public void adicionaPessoa(Pessoa pessoa){
        try{
            String query = "INSERT INTO pessoas (nome, rg, cpf)" +
                    " VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getRG());
            ps.setString(3, pessoa.getCPF());
            ps.executeUpdate();
            ps.close();
        }catch (Exception ex){
            System.out.println("Erro ao inserir");
            ex.printStackTrace();
        }
    }
    //selecionar
    public Pessoa buscaPessoa(int id) {
        Pessoa p = null;
        try {
            String query = "Select * from pessoas where id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Pessoa();
                p.setNome(rs.getString("nome"));
                p.setCPF(rs.getString("CPF"));
                p.setRG(rs.getString("RG"));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;
    }

    //listarTodas
    public List<Pessoa> listarPessoas(){
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try{
            String query = "select * from pessoas";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Pessoa p = new Pessoa();
                p.setNome(rs.getString("nome"));
                p.setCPF(rs.getString("CPF"));
                p.setRG(rs.getString("RG"));
                pessoas.add(p);
            }

            rs.close();
            ps.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return pessoas;
    }

    //Atualizar

    public void atualizarPessoa(Pessoa pessoa){
        try{
            String query = "UPDATE pessoas SET nome=?, cpf=?, rg=? where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCPF());
            ps.setString(3, pessoa.getRG());
            ps.setString(4, pessoa.getCPF());

            ps.executeUpdate();


        }catch (Exception ex){
            System.out.println("Erro na atualização");
            ex.printStackTrace();
        }
    }

    public void atualizarPessoa(int id, Pessoa pessoa){
        try{
            String query = "UPDATE pessoas SET nome=?, cpf=?, rg=? where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCPF());
            ps.setString(3, pessoa.getRG());
            ps.setInt(4, id);

            ps.executeUpdate();


        }catch (Exception ex){
            System.out.println("Erro na atualização");
            ex.printStackTrace();
        }
    }

    //Excluir
    public void deletarPessoa(int id){
        try{
            String query = "delete from pessoas where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);

            ps.executeUpdate();
            ps.close();

        }catch(Exception ex){
            System.out.println("Erro na exclusão");
            ex.printStackTrace();
        }
    }

    public void deletarPessoa(Pessoa pessoa){
        try{
            String query = "delete from pessoas where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pessoa.getCPF());

            ps.executeUpdate();
            ps.close();

        }catch(Exception ex){
            System.out.println("Erro na exclusão");
            ex.printStackTrace();
        }
    }

}
