package com.github.lucasdevrj.cadastrodeshinobi.missao;

import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiDTO;
import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("missoes/ui")
public class MissaoControllerUi {

    private final MissaoService missaoService;
    private final ShinobiService shinobiService;


    public MissaoControllerUi(MissaoService missaoService, ShinobiService shinobiService) {
        this.missaoService = missaoService;
        this.shinobiService = shinobiService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model) { //biblioteca com interfaces gráficas
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "missoes.html";
    }

    @PostMapping("/adiciona")
    public String adicionaMissao(@ModelAttribute MissaoDTO missaoDTO) {
        missaoService.adicionar(missaoDTO);
        return "redirect:/missoes/ui/listar";
    }

    // Exibir o formulário de cadastro
    @GetMapping("/formularioCadastro")
    public String exibirFormulario(Model model) {
        // Cria um objeto vazio para o formulário
        List<ShinobiDTO> shinobis = shinobiService.listarShinobis();
        model.addAttribute("shinobis", shinobis);
        model.addAttribute("missao", new MissaoDTO());
        return "adiciona-missao.html"; // Nome do arquivo HTML
    }
}
