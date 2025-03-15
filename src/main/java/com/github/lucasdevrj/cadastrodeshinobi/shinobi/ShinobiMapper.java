package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

//Classe para mapear/juntar as classes Model com a DTO
//Pois assim adicionamos mais uma camada de abstração ao Banco de Dados da aplicação
//Dará mais segurança a aplicação

import org.springframework.stereotype.Component;

@Component
public class ShinobiMapper {

    public ShinobiModel map(ShinobiDTO shinobiDTO) {
        ShinobiModel shinobiModel = new ShinobiModel();
        shinobiModel.setId(shinobiDTO.getId());
        shinobiModel.setNome(shinobiDTO.getNome());
        shinobiModel.setEmail(shinobiDTO.getEmail());
        shinobiModel.setImagemUrl(shinobiDTO.getImagemUrl());
        shinobiModel.setRank(shinobiDTO.getRank());
        shinobiModel.setIdade(shinobiDTO.getIdade());
        shinobiModel.setMissao(shinobiDTO.getMissao());
        return shinobiModel;
    }

    public ShinobiDTO map(ShinobiModel shinobiModel) {
        ShinobiDTO shinobiDTO = new ShinobiDTO();
        shinobiDTO.setId(shinobiModel.getId());
        shinobiDTO.setNome(shinobiModel.getNome());
        shinobiDTO.setEmail(shinobiModel.getEmail());
        shinobiDTO.setImagemUrl(shinobiModel.getImagemUrl());
        shinobiDTO.setRank(shinobiModel.getRank());
        shinobiDTO.setIdade(shinobiModel.getIdade());
        shinobiDTO.setMissao(shinobiModel.getMissao());
        return shinobiDTO;
    }

}
