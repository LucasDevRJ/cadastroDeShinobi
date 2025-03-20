package com.github.lucasdevrj.cadastrodeshinobi.missao;

import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiDTO;
import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //indica que a classe é um Service, o qual tem os métodos da lógica da API
public class MissaoService {

    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    //lógica para listar as missões
    public List<MissaoDTO> listarMissoes() {
        List<MissaoModel> shinobis = missaoRepository.findAll();
        return shinobis.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    //Lógica para procurar e pegar a missão deseja por id
    public MissaoModel buscarPorId(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }

    //Lógica para função de atualizar Missão
    public MissaoModel atualizar(Long id, MissaoModel missaoAtualizada) {
        if (missaoRepository.existsById(id)) {
            missaoAtualizada.setId(id);
            return missaoRepository.save(missaoAtualizada);
        }
        return null;
    }

    //função para adicionar Missão
    public MissaoDTO adicionar(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    //função para deletar Missão
    public void deletar(Long id) {
        missaoRepository.deleteById(id);
    }
}
