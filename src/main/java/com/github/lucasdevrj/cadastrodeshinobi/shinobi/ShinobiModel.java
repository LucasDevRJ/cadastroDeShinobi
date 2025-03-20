package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import com.github.lucasdevrj.cadastrodeshinobi.missao.MissaoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //transforma um classe em uma entidade no Banco de Dados
@Table(name = "tb_shinobis") //Criar a tabela com o nome definido
@NoArgsConstructor //construtor sem atributos
@AllArgsConstructor //construtor com todos os atributos
@Data //Getters e Setters dos atributos
@ToString(exclude = "missao") //adiciona o toString que modifica o valor referência do Objeto. Exclude interrompe o loop de execução
public class ShinobiModel {

    @Id //para gerar ID's na entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para gerar os ID's numericamente e sequenciais
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    @NotBlank
    private String nome;

    @Column(unique = true) //valor não poderá ser replicado
    @Email
    private String email;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @Column(name = "idade")
    @Min(1)
    private int idade;

    @Column(name = "rank")
    private String rank;

    @ManyToOne //muitos ninjas podem fazer uma missão
    @JoinColumn(name = "missoes_id") //chave estrangeira
    private MissaoModel missao;
}
