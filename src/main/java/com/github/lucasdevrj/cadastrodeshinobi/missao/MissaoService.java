package com.github.lucasdevrj.cadastrodeshinobi.missao;

import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

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

    //Lógica para procurar e pegar a missão deseja por id
    public MissaoModel buscarPorId(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }

    //função para adicionar Missão
    public MissaoModel adicionar(MissaoModel missao) {
        return missaoRepository.save(missao);
    }
}
