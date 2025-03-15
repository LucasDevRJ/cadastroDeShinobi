package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import com.github.lucasdevrj.cadastrodeshinobi.missao.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShinobiDTO {

    private Long id;
    private String nome;
    private String email;
    private String imagemUrl;
    private int idade;
    private String rank;
    private MissaoModel missao;
}
