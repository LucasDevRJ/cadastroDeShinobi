package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShinobiService {

    private ShinobiRepository shinobiRepository;

    public ShinobiService(ShinobiRepository shinobiRepository) {
        this.shinobiRepository = shinobiRepository;
    }

    public List<ShinobiModel> listarShinobis() {
        return shinobiRepository.findAll();
    }
}
