import java.util.ArrayList;

public class ClassesDoProjeto {
    public static void main(String[] args) {
    }
}

class Gestor {
    String nome, endereco, email, contato;

    ArrayList<Voluntario> listadevoluntarios = new ArrayList<>();
    ArrayList<Tutor> listadetutores = new ArrayList<>();
    ArrayList<Doador> listadeDoadores = new ArrayList<>();
    ArrayList<Integer> listadeAlimentos = new ArrayList<>();
    ArrayList<Integer> listadeMedicamentos = new ArrayList<>();



    public void cadastrarVoluntario(Voluntario voluntario){
        listadevoluntarios.add(voluntario);
        System.out.println("O voluntário: " + voluntario.getNome() + ",foi cadastrado");
    }

    public void consultarTabeladeVoluntarios(){
        for (int indice = 0; indice < listadevoluntarios.size(); indice ++){
            System.out.println(listadevoluntarios.get(indice));
        }
    }

    public void apagarVoluntariosDespensados(Voluntario voluntario){
        listadevoluntarios.remove(voluntario);
        System.out.println("O voluntários selecionado foi apagado");

    }

    public void cadastrarTutores(Tutor tutor){
        listadetutores.add(tutor);
        System.out.println("O Tutor: " + tutor.getNome() + ",foi cadastrado");
    }

    public void registrarDoadores(Doador doador){
        listadeDoadores.add(doador);
        System.out.println("O doador: " + doador.getNome() + ",foi registrado em sistema e fez uma doação de: " + doador.getQuantidadeDeDoacao() + ",do tipo: " + doador.getTipoDeDoacao());
    }

    public void consultarListaDeAlimentos(){
        for (int indice = 0; indice < listadeAlimentos.size(); indice ++){
            System.out.println("A lista atual possui: " + 0+listadeAlimentos.get(indice) + "Alimentos");
        }
    }

    public void consultarListaDeMedicamentos(){
        for (int indice = 0; indice < listadeMedicamentos.size(); indice ++){
            System.out.println("A lista atual possui: " + 0+listadeMedicamentos.get(indice) + "Medicamentos");
        }
    }

    public void ModificarListaDeAlimentos(int alimentosAModificar){
        //A parte logica modificação de valores na lista ficou faltando.
    }

    public void ModificarListaDeMedicamentos(int MedicamentosAModificar){
        //A parte logica modificação de valores na lista ficou faltando.
    }

    public void AtualizarDadosDoCentro(String novoContato, String novoEmail, String novoEndereco){
        setContato(novoContato);
        setEmail(novoEmail);
        setEndereco(novoEndereco);
        System.out.println("Os dados do centro foram atualizados");
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}


class Doador{
    String nome , TipoDeDoacao;
    int identificador, QuantidadeDeDoacao;

    public Doador(String nome, int identificador, String tipoDeDoacao, int quantidadeDeDoacao) {
        this.nome = nome;
        this.identificador = identificador;
        TipoDeDoacao = tipoDeDoacao;
        QuantidadeDeDoacao = quantidadeDeDoacao;
    }

    public Doador(int quantidadeDeDoacao, String tipoDeDoacao) {
        QuantidadeDeDoacao = quantidadeDeDoacao;
        TipoDeDoacao = tipoDeDoacao;
    }

    public void realizarNovaDoacao(int quantidadeDeDoacao , String tipoDeDoacao, Gestor gestor){
        System.out.println("o Doador: " + getNome() + ",realizou uma doação de: " + quantidadeDeDoacao + " de " + tipoDeDoacao + ",para o Centro de Resgate");
        Doador d = new Doador(quantidadeDeDoacao,tipoDeDoacao);
        if (tipoDeDoacao == "Medicamento"){gestor.listadeMedicamentos.add(quantidadeDeDoacao);
        }else{
            gestor.listadeAlimentos.add(quantidadeDeDoacao);
        }
    }

    public void consultarFuturasDemandas(Gestor gestor){
        gestor.consultarListaDeAlimentos();
        gestor.consultarListaDeMedicamentos();
    }

    public String getNome() {
        return nome;
    }

    public String getTipoDeDoacao() {
        return TipoDeDoacao;
    }

    public void setTipoDeDoacao(String tipoDeDoacao) {
        TipoDeDoacao = tipoDeDoacao;
    }

    public int getQuantidadeDeDoacao() {
        return QuantidadeDeDoacao;
    }

    public void setQuantidadeDeDoacao(int quantidadeDeDoacao) {
        QuantidadeDeDoacao = quantidadeDeDoacao;
    }

    @Override
    public String toString() {
        return "Doador{" +
                "nome='" + nome + '\'' +
                ", identificador=" + identificador +
                ", QuantidadeDeDoacao=" + QuantidadeDeDoacao +
                ", TipoDeDoacao='" + TipoDeDoacao + '\'' +
                '}';
    }
}


class Voluntario{
    String nome, telefone, funcao, Horario;

    public Voluntario(String nome, String telefone, String funcao, String horario) {
        this.nome = nome;
        this.telefone = telefone;
        this.funcao = funcao;
        Horario = horario;
    }

    ArrayList<Animal> listadeanimaisResgatados = new ArrayList();
    ArrayList<String> listadehorariosdosresgates = new ArrayList();
    ArrayList<Animal> listadeanimaisAdotados = new ArrayList();
    ArrayList<String> listadetratamentos = new ArrayList<>();

    public void CadastrarAnimal(Animal animalResgatado , String horadoResgate){
        System.out.println("o animal foi cadastrado com sucesso");
        listadeanimaisResgatados.add(animalResgatado);
        listadehorariosdosresgates.add(horadoResgate);
    }

    public void consultarListaDeAnimalPorEspecie(String especie){
        //falta realizar a consulta na lista por especie
    }

    public void consultarListaDeAnimalPorStatus(boolean status) {
        for (int indice = 0; indice < listadeanimaisResgatados.size(); indice++) {
            if (status = true) {
                System.out.println(listadeanimaisResgatados.get(indice));
            } else {
                System.out.println("Não tem animais disponíveis ainda");
            }
        }
    }

    public void RegistrarTratamento(String tratamento, Animal animal){
        System.out.println("O tratamento: " + tratamento + ",foi realizado para o animal: " + animal.getEspecie());
        listadetratamentos.add(tratamento);
    }

    public void AlimentarAnimal(Animal animal){
        System.out.println("O animal está sendo alimentado no momento");
        //Ficou faltando a logica para remover 1 da lista de alimentos

    }

    public void ConsultarHistoricoDeResgates(){
        for (int indice = 0; indice < listadehorariosdosresgates.size(); indice ++){
            System.out.println(listadehorariosdosresgates.get(indice));
        }
    }

    public void RegistrarAdocao(Tutor tutor , Animal animal){
        System.out.println("O tutor: " + tutor.getNome() + "Adotou o Animal: " + animal.getEspecie());
        listadeanimaisResgatados.remove(animal);
        listadeanimaisAdotados.add(animal);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "nome='" + nome + '\'' +
                ", funcao='" + funcao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", Horario='" + Horario + '\'' +
                '}';
    }
}


class Tutor{
    String nome, numeroDeTelefone,endereco;
    int AnimaisAdotados;

    public Tutor(String nome, String numeroDeTelefone, String endereco) {
        this.nome = nome;
        this.numeroDeTelefone = numeroDeTelefone;
        this.endereco = endereco;
    }

    public void realizarAdocao(Animal animal , Voluntario voluntario){
        System.out.println("O tutor: " + getNome() + "Deseja realizar a adoção do animal: " + animal + "Resgatado pelo Voluntário: " + voluntario);
        if (voluntario.listadeanimaisResgatados.contains(animal)){
            voluntario.RegistrarAdocao(Tutor.this,animal);
        }

    }
    public void conferirDescricaoDoAnimal(Animal animal){
        System.out.println(animal.getDescricao());
    }
    public void AcessarTabelaDeTratamentos(Voluntario voluntario){
        voluntario.ConsultarHistoricoDeResgates();
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "nome='" + nome + '\'' +
                ", numeroDeTelefone='" + numeroDeTelefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

}


class Animal{

    public Animal(String especie, String raca, String sexo, String descricao, int idadeEstimada, boolean statusDeAdocao, int ID) {
        Especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.descricao = descricao;
        this.idadeEstimada = idadeEstimada;
        boolean StatusDeAdocao = statusDeAdocao;
        this.ID = ID;

    }

    public Animal(int ID) {
        this.ID = ID;
    }

    String Especie, raca , sexo, descricao;
    int idadeEstimada , ID;
    boolean StatusDeAdocao;

    public void comer(){
        System.out.println( getEspecie() + " Comeu uma parte da ração diária");
    }

    public void dormir(int horasDeSono){
        System.out.println( getEspecie() + " Está dormindo no momento e tem um total de: " + horasDeSono + " Horas de sono.");

    }
    public String getEspecie() {
        return Especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isStatusDeAdocao() {
        return StatusDeAdocao;
    }

    public void setStatusDeAdocao(boolean statusDeAdocao) {
        StatusDeAdocao = statusDeAdocao;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Especie='" + Especie + '\'' +
                ", raca='" + raca + '\'' +
                ", sexo='" + sexo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", idadeEstimada=" + idadeEstimada +
                ", StatusDeAdocao=" + StatusDeAdocao +
                '}';
    }
}