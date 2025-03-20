package com.github.lucasdevrj.cadastrodeshinobi.missao;

import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("missoes/ui")
public class MissaoControllerUi {

    private final MissaoService missaoService;

    public MissaoControllerUi(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model) { //biblioteca com interfaces gráficas
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "missoes.html";
    }
}
