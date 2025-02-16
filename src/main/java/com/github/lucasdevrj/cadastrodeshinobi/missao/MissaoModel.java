package com.github.lucasdevrj.cadastrodeshinobi.missao;

import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String rank;
    @OneToMany(mappedBy = "missao") //uma missão pode ser feita por muitos ninjas
    private List<ShinobiModel> shinobis;

    public MissaoModel() {

    }

    public MissaoModel(String nome, String rank) {
        this.nome = nome;
        this.rank = rank;
    }

    public MissaoModel(String nome, String descricao, String rank) {
        this.nome = nome;
        this.descricao = descricao;
        this.rank = rank;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
