package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import com.github.lucasdevrj.cadastrodeshinobi.missao.MissaoDTO;
import com.github.lucasdevrj.cadastrodeshinobi.missao.MissaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("shinobis/ui")
public class ShinobiControllerUi {

    private final ShinobiService shinobiService;
    private final MissaoService missaoService;

    public ShinobiControllerUi(ShinobiService shinobiService, MissaoService missaoService) {
        this.shinobiService = shinobiService;
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public String listarShinobis(Model model) { //biblioteca com interfaces gráficas
        List<ShinobiDTO> shinobis = shinobiService.listarShinobis();
        model.addAttribute("shinobis", shinobis);
        return "index.html";
    }

    // Exibir o formulário de cadastro
    @GetMapping("/adiciona")
    public String exibirFormulario(Model model) {
         // Cria um objeto vazio para o formulário
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        model.addAttribute("missoes", missoes);
        model.addAttribute("shinobi", new ShinobiDTO());
        return "formulario-shinobi.html"; // Nome do arquivo HTML
    }

    // Salvar o produto
    @PostMapping("/salvar")
    public String salvarShinobi(@ModelAttribute ShinobiDTO shinobiDTO) {
        shinobiService.adicionarShinobi(shinobiDTO);
        return "redirect:/shinobis/ui/listar"; // Redireciona para a lista após salvar
    }

    // Método GET para carregar a página de edição com o Ninja
    @GetMapping("/atualizar/{id}")
    public String redirecionaPaginaAtualizacaoShinobi(@PathVariable("id") Long id, Model model) {
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        model.addAttribute("missoes", missoes);
        ShinobiDTO shinobi = shinobiService.exibirShinobiPorID(id);
        model.addAttribute("shinobi", shinobi);  // Passa o Ninja para a página de edição
        return "formulario-shinobi.html";  // Nome da página de edição (HTML/Thymeleaf)
    }

    // Método POST para atualizar o Ninja
    @PostMapping("/atualizar/{id}")
    public String atualizarShinobi(@PathVariable("id") Long id, @ModelAttribute ShinobiDTO shinobi) {
        shinobiService.atualizar(id, shinobi);
        return "redirect:/listar";  // Redireciona para a página de listagem de ninjas
    }

    @GetMapping("/deletar/{id}")
    public String deletarShinobi(@PathVariable Long id) {
        shinobiService.deletarShinobiPorID(id);
        return "redirect:/shinobis/ui/listar"; // redireciona para a listagem após deletar
    }
}
