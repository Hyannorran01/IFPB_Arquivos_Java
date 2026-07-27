public class LivroDigital extends Livro{
    public LivroDigital(String titulo){
        super(titulo);
    }


    @Override
    public void emprestar() throws LivroIndisponivelException {
        super.emprestar();
    }
}
