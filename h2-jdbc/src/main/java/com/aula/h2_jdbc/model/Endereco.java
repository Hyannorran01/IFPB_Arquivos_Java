package com.aula.h2_jdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ENDERECO")
public record Endereco(

        @Id
        @Column( value = "ID")
        Long id,

        @Column(value = "RUA")
        String rua,

        @Column(value = "CIDADE")
        String cidade,

        @Column(value = "ALUNO_ID")
        Long alunoId
) {

}
