package QuestionException3;

public class Usuario {
    private String senhadoUsuario;

    public void setSenha(String senha) throws SenhaInvalidaException {
        if (senha.length() < 8) {
            throw new SenhaInvalidaException("A senha deve ter no mínimo 8 caracteres.");
        }
        else if (!senha.matches(".*\\d.*")) {
            throw new SenhaInvalidaException("Aviso de Invalido: A senha deve conter pelo menos um número.");
        }
        else if (!senha.matches(".*[A-Z].*")) {
            throw new SenhaInvalidaException("Aviso de Invalidez: senha deve conter pelo menos uma letra maiúscula.");
        }
        this.senhadoUsuario = senha;
        System.out.println("Senha cadastrada com sucesso.");
    }
}
