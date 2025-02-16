package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import com.github.lucasdevrj.cadastrodeshinobi.missao.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //transforma um classe em uma entidade no Banco de Dados
@Table(name = "tb_shinobis") //Criar a tabela com o nome definido
@NoArgsConstructor //construtor sem atributos
@AllArgsConstructor //construtor com todos os atributos
@Data //Getters e Setters dos atributos
public class ShinobiModel {

    @Id //para gerar ID's na entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para gerar os ID's numericamente e sequenciais
    private Long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne //muitos ninjas podem fazer uma missão
    @JoinColumn(name = "missoes_id") //chave estrangeira
    private MissaoModel missao;
}
