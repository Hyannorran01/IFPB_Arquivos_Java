//Crie um sistema simples de cadastro de usuário onde a senha precisa seguir
//algumas regras.
//Requisitos:
//- Crie uma exceção personalizada chamada SenhaInvalidaException.
//Esta exceção deve ser uma Checked Exception (extenda Exception).
//- A SenhaInvalidaException deve ter um construtor que aceita uma
//String como mensagem.
//- Crie uma classe Usuario com um método setSenha(String senha) que
//valida a senha.
//As regras de validação da senha são:
//Deve ter no mínimo 8 caracteres.
//Deve conter pelo menos um número.
//Deve conter pelo menos uma letra maiúscula.
//
//- Se a senha não atender a alguma regra, o método setSenha deve
//lançar (throw) uma SenhaInvalidaException com uma mensagem
//descritiva do erro.
//- No método main de uma classe App, peça ao usuário para digitar
//uma senha e use um bloco try-catch para chamar o setSenha.

package QuestionException3;

import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario();

        System.out.print("Digite sua senha seguindo os padrões de: 8 Caracteres, 1 letra Maiscula, 1 número");
        String senha = sc.nextLine();

        try {
            usuario.setSenha(senha);
        } catch (SenhaInvalidaException mensagemException) {
            System.out.println("Senha incorreta: " + mensagemException.getMessage());
        }
    }
}
