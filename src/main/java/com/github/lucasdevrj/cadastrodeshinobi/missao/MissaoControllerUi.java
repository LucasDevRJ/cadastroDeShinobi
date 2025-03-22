package com.github.lucasdevrj.cadastrodeshinobi.missao;

import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiDTO;
import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiModel;
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

    @PostMapping("/adicionaMissao")
    public String adicionaMissao(@ModelAttribute MissaoDTO missaoDTO) {
        missaoService.adicionar(missaoDTO);
        return "redirect:/missoes/ui/listar";
    }

    // Exibir o formulário de cadastro
    @GetMapping("/redirecionaFormularioAdicionaMissao")
    public String redirecionaPaginaAdicionaMissao(Model model) {
        // Cria um objeto vazio para o formulário
        List<ShinobiDTO> shinobis = shinobiService.listarShinobis();
        model.addAttribute("shinobis", shinobis);
        model.addAttribute("missao", new MissaoDTO());
        return "adiciona-missao.html"; // Nome do arquivo HTML
    }

    // Método GET para carregar a página de edição com o Ninja
    @GetMapping("/redirecionaFormularioAtualizaMissao/{id}")
    public String redirecionaPaginaAtualizacaoMissao(@PathVariable("id") Long id, Model model) {
        List<ShinobiDTO> shinobis = shinobiService.listarShinobis();
        model.addAttribute("shinobis", shinobis);
        MissaoDTO missao = missaoService.exibirMissaoPorID(id);
        model.addAttribute("missao", missao);  // Passa o Ninja para a página de edição
        return "atualiza-missao.html";  // Nome da página de edição (HTML/Thymeleaf)
    }

    // Método POST para atualizar o Ninja
    @PostMapping("/atualizaMissao/{id}")
    public String atualizarMissao(@PathVariable("id") Long id, @ModelAttribute MissaoDTO missao) {
        missaoService.atualizar(id, missao);
        return "redirect:/missoes/ui/listar";  // Redireciona para a página de listagem de ninjas
    }

    @GetMapping("/deletar/{id}")
    public String deletarShinobi(@PathVariable Long id) {
        missaoService.deletar(id);
        return "redirect:/missoes/ui/listar"; // redireciona para a listagem após deletar
    }
}
