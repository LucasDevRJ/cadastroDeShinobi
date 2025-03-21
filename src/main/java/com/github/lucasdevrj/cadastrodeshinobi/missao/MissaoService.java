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
    public MissaoDTO exibirMissaoPorID(Long id) {
        Optional<MissaoModel> missaoBuscadaPorId = missaoRepository.findById(id);
        return missaoBuscadaPorId.map(missaoMapper::map).orElse(null);
    }

    //Lógica para função de atualizar Missão
    //Transferindo a responsabilidade de atualizar o Shinobi para o DTO
    public MissaoDTO atualizar(Long id, MissaoDTO missaoDTO) {
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissaoModel missaoAtualizada = missaoMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissaoModel missaoSalva = missaoRepository.save(missaoAtualizada);
            return missaoMapper.map(missaoSalva);
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
