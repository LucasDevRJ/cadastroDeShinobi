package com.github.lucasdevrj.cadastrodeshinobi.missao;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissaoModel map(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDescricao(missaoDTO.getDescricao());
        missaoModel.setRank(missaoDTO.getRank());
        missaoModel.setShinobis(missaoDTO.getShinobis());
        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDescricao(missaoModel.getDescricao());
        missaoDTO.setRank(missaoModel.getRank());
        missaoDTO.setShinobis(missaoModel.getShinobis());
        return missaoDTO;
    }
}
