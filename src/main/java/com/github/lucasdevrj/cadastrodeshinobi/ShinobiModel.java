package com.github.lucasdevrj.cadastrodeshinobi;

import jakarta.persistence.*;

@Entity //transforma um classe em uma entidade no Banco de Dados
@Table(name = "tb_shinobis") //Criar a tabela com o nome definido
public class ShinobiModel {

    @Id //para gerar ID's na entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para gerar os ID's numericamente e sequenciais
    Long id;
    String nome;
    String email;
    int idade;

    public ShinobiModel() {

    }

    public ShinobiModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
