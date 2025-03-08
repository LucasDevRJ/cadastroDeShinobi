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

    public ShinobiModel exibirNinjaPorID(Long id) {
        Optional<ShinobiModel> shinobiBuscadoPorID = shinobiRepository.findById(id);
        return shinobiBuscadoPorID.orElse(null);
    }

    public ShinobiModel adicionarShinobi(ShinobiModel shinobi) {
        return shinobiRepository.save(shinobi);
    }
}
