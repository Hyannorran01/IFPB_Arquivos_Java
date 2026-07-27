//Passo 1: implementar as classes conforme o diagrama;
//Passo 2: criar construtores padrão para cada classe e imprimir seus respectivos
//nomes;
//Passo 3: criar construtores que receba como parâmetros variáveis para inicializar os
//atributos; uso do base.
//Passo 4: criar os métodos gets e sets;
//Passo 5: criar uma classe Principal com o método main para criar as instâncias p, pF
//e pJ de sua respectivas classes.
//Passo 6: Verificar o que ocorre se chamar p.SetCPF() e p.setCNPJ() e explique;
//Passo 7: Verificar o que será impresso ao chamar o construtor padrão de
//PessoaFisica e de PessoaJuridica. uso cadeia de construtores.

import java.util.Calendar;

public class Question9 {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Cristian");
        PessoaFisica pF = new PessoaFisica("Pluctorios Morales");
        PessoaJuridica pJ = new PessoaJuridica("IFCG");

        //p.SetCPF() e p.SetCNPJ não funcionam//

        pF.setCpf("111.222.333-44");
        pJ.setCnpj("000.000/0001-11");

    }
}
    class Pessoa{
        private String nome;
        private String endereco;
        private String telefone;

        public Pessoa(String nome) {
            this.nome = nome;
            System.out.println("O nome é: " + nome);
        }

        public Pessoa(String nome, String endereco, String telefone) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public void calcularImpostoDeRenda(){}

    }


    class PessoaFisica extends Pessoa{
        private String cpf;
        private String rg;
        private Calendar dataNascimento;

        public PessoaFisica(String nome) {
            super(nome);
        }

        public PessoaFisica(String nome, String endereco, String telefone, String cpf, String rg, Calendar dataNascimento){
            super(nome, endereco, telefone);
            this.cpf = cpf;
            this.rg = rg;
            this.dataNascimento = dataNascimento;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getRg() {
            return rg;
        }

        public void setRg(String rg) {
            this.rg = rg;
        }

        public Calendar getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(Calendar dataNascimento) {
            this.dataNascimento = dataNascimento;
        }
    }


    class PessoaJuridica extends Pessoa{
        private String cnpj;
        private String inscricaoEstadual;
        private String inscricaoMunicipal;

        public PessoaJuridica(String nome) {
            super(nome);
        }

        public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String inscricaoEstadual, String inscricaoMunicipal) {
            super(nome, endereco, telefone);
            this.cnpj = cnpj;
            this.inscricaoEstadual = inscricaoEstadual;
            this.inscricaoMunicipal = inscricaoMunicipal;
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getInscricaoEstadual() {
            return inscricaoEstadual;
        }

        public void setInscricaoEstadual(String inscricaoEstadual) {
            this.inscricaoEstadual = inscricaoEstadual;
        }

        public String getInscricaoMunicipal() {
            return inscricaoMunicipal;
        }

        public void setInscricaoMunicipal(String inscricaoMunicipal) {
            this.inscricaoMunicipal = inscricaoMunicipal;
        }
    }

