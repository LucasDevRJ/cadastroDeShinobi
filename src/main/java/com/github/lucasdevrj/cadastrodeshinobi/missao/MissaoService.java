package com.github.lucasdevrj.cadastrodeshinobi.missao;

import org.springframework.stereotype.Service;
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

    //Lógica para função de atualizar Missão
    public MissaoModel atualizar(Long id, MissaoModel missaoASerAtualizada) {
        MissaoModel missaoAtualizada = buscarPorId(id);

        missaoAtualizada.setNome(missaoASerAtualizada.getNome());
        missaoAtualizada.setDescricao(missaoASerAtualizada.getDescricao());
        missaoAtualizada.setRank(missaoASerAtualizada.getRank());

        return missaoRepository.save(missaoAtualizada);
    }

    //função para adicionar Missão
    public MissaoModel adicionar(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    //função para deletar Missão
    public void deletar(Long id) {
        missaoRepository.deleteById(id);
    }
}
