package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShinobiService {

    private ShinobiRepository shinobiRepository;
    private ShinobiMapper shinobiMapper;

    public ShinobiService(ShinobiRepository shinobiRepository, ShinobiMapper shinobiMapper) {
        this.shinobiRepository = shinobiRepository;
        this.shinobiMapper = shinobiMapper;
    }

    //Convertendo de Model para DTO
    //Retornando a lista de shinobis com DTO
    public List<ShinobiDTO> listarShinobis() {
        List<ShinobiModel> shinobis = shinobiRepository.findAll();
        return shinobis.stream()
                .map(shinobiMapper::map)
                .collect(Collectors.toList());
    }

    public ShinobiDTO exibirShinobiPorID(Long id) {
        Optional<ShinobiModel> shinobiBuscadoPorID = shinobiRepository.findById(id);
        return shinobiBuscadoPorID.map(shinobiMapper::map).orElse(null);
    }

    //transferindo de Model para DTO, assim tendo mais segurança na aplicação
    //salvando o ninja no banco de dados através do repository
    public ShinobiDTO adicionarShinobi(ShinobiDTO shinobiDTO) {
        ShinobiModel shinobi =  shinobiMapper.map(shinobiDTO);
        shinobi = shinobiRepository.save(shinobi);
        return shinobiMapper.map(shinobi);
    }

    //tem que ser uma função void, pois não será necessário mandar nada ao servidor
    //não é preciso transferir de DTO para Model, pois é passado somente um querie SQL para deleção
    public void deletarShinobiPorID(Long id) {
        shinobiRepository.deleteById(id);
    }

    //Transferindo a responsabilidade de atualizar o Shinobi para o DTO
    public ShinobiDTO atualizar(Long id, ShinobiDTO shinobiDTO) {
        Optional<ShinobiModel> shinobiExistente = shinobiRepository.findById(id);
        if (shinobiExistente.isPresent()) {
            ShinobiModel shinobiAtualizado = shinobiMapper.map(shinobiDTO);
            shinobiAtualizado.setId(id);
            ShinobiModel shibobiSalvo = shinobiRepository.save(shinobiAtualizado);
            return shinobiMapper.map(shibobiSalvo);
        }
        return null;
    }
}
