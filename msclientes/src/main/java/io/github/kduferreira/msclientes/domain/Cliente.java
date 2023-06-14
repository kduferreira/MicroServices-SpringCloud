package io.github.kduferreira.msclientes.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

private Long id;

private String cpf;

private String nome;

private Integer idade;


public Cliente (String cpf, String nome, Integer idade) {
    this.cpf = cpf;
    this.nome = nome;
    this.idade = idade;
}



}
