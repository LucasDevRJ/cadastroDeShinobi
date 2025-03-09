package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShinobiService {

    private ShinobiRepository shinobiRepository;

    public ShinobiService(ShinobiRepository shinobiRepository) {
        this.shinobiRepository = shinobiRepository;
    }

    public List<ShinobiModel> listarShinobis() {
        return shinobiRepository.findAll();
    }

    public ShinobiModel exibirShinobiPorID(Long id) {
        Optional<ShinobiModel> shinobiBuscadoPorID = shinobiRepository.findById(id);
        return shinobiBuscadoPorID.orElse(null);
    }

    public ShinobiModel adicionarShinobi(ShinobiModel shinobi) {
        return shinobiRepository.save(shinobi);
    }

    //tem que ser uma função void, pois não será necessário mandar nada ao servidor
    public void deletarShinobiPorID(Long id) {
        shinobiRepository.deleteById(id);
    }

    public ShinobiModel atualizar(Long id, ShinobiModel shinobiAtualizado) {
        if (shinobiRepository.existsById(id)) {
            shinobiAtualizado.setId(id);
            return shinobiRepository.save(shinobiAtualizado);
        }
        return null;
    }
}
