package com.github.lucasdevrj.cadastrodeshinobi.missao;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service //indica que a classe é um Service, o qual tem os métodos da lógica da API
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //lógica para listar as missões
    public List<MissaoModel> listar() {
        return missaoRepository.findAll();
    }
}
