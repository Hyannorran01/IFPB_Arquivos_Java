package com.aula.h2_jdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ALUNO")
public class Aluno{

        @Id
        @Column( value = "ID")
        private Long id;

        @Column(value = "NOME")
        private String nome;

        @Column(value = "MATRICULA")
        private String matricula;

        public Aluno(Long id, String nome, String matricula) {
                this.id = id;
                this.nome = nome;
                this.matricula = matricula;
        }

        public Aluno() {}

        public Aluno(String nome, String matricula) {
                this.nome = nome;
                this.matricula = matricula;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getMatricula() {
                return matricula;
        }

        public void setMatricula(String matricula) {
                this.matricula = matricula;
        }
}

