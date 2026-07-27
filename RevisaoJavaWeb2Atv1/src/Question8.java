//Crie uma classe abstrata chamada Animal, com os seguintes atributos: nome,
//especie, idade, dono (referência à classe Dono, Crie uma classe dono com nome e
//cpf de atributos)
//a. E os seguintes métodos:
//
//Um construtor que inicialize os atributos.
//Um método abstrato emitirSom().
//Um método exibirInfo() que mostre os dados do animal e do dono.
//b. Em seguida, crie duas classes concretas que herdam de Animal:
//Cachorro
//Gato
//Cada uma deve sobrescrever o método emitirSom() com uma mensagem
//correspondente (ex: "Au Au" ou "Miau").

public class Question8 {

    abstract class Animal {
        private String nome;
        private String especie;
        private int idade;
        private Dono dono;

        public Animal(String nome, String especie, int idade, Dono dono) {
            this.nome = nome;
            this.especie = especie;
            this.idade = idade;
            this.dono = dono;
        }

        public void emitirSom() {

        }

        @Override
        public String toString() {
            return "Animal{" +
                    "nome='" + nome + '\'' +
                    ", especie='" + especie + '\'' +
                    ", idade=" + idade +
                    ", dono=" + dono +
                    '}';
        }

        public String emitirInfor() {
            return toString();
        }
    }


    class Dono {
        private String nome;
        private String cpf;

        public Dono(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }
    }


    class Gato extends Animal {

        public Gato(String nome, String especie, int idade, Dono dono) {
            super(nome, especie, idade, dono);
        }

        @Override
        public void emitirSom() {
            System.out.println("Myoown");
        }
    }


    class Cachorro extends Animal {

        public Cachorro(String nome, String especie, int idade, Dono dono) {
            super(nome, especie, idade, dono);
        }

        @Override
        public void emitirSom() {
            System.out.println("Auuf Auuf");
        }
    }
}