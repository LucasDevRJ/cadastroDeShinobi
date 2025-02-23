package com.github.lucasdevrj.cadastrodeshinobi.missao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String rank;
    @OneToMany(mappedBy = "missao") //uma missão pode ser feita por muitos ninjas
    @JsonIgnore //para ignorar o loop de dados das Missões
    private List<ShinobiModel> shinobis;
}
