package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("shinobis/ui")
public class ShinobiControllerUi {

    private final ShinobiService shinobiService;

    public ShinobiControllerUi(ShinobiService shinobiService) {
        this.shinobiService = shinobiService;
    }

    @GetMapping("/listar")
    public String listarShinobis(Model model) { //biblioteca com interfaces gráficas
        List<ShinobiDTO> shinobis = shinobiService.listarShinobis();
        model.addAttribute("shinobis", shinobis);
        return "listar-shinobis.html";
    }

    // Exibir o formulário de cadastro
    @GetMapping("/adiciona")
    public String exibirFormulario(Model model) {
        model.addAttribute("shinobi", new ShinobiDTO()); // Cria um objeto vazio para o formulário
        return "adiciona-shinobi.html"; // Nome do arquivo HTML
    }

    // Salvar o produto
    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute ShinobiDTO shinobiDTO) {
        shinobiService.adicionarShinobi(shinobiDTO);
        return "redirect:/listar"; // Redireciona para a lista após salvar
    }
}
