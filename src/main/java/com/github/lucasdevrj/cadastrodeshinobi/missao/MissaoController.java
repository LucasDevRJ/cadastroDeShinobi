package com.github.lucasdevrj.cadastrodeshinobi.missao;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping("missoes")//rota da qual acessaremos a API
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    //POST - Enviar requisição para criar uma Missão
    @PostMapping("/adicionar")
    public String adicionarMissao() {
        return "Missão criada com sucesso!";
    }

    //GET - Enviar requisição para listar Missões
    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes() {
        return missaoService.listar();
    }

    //GET - Enviar requisição para exibir Missão por ID
    @GetMapping("/exibirPorID/{id}")
    public MissaoModel exibirMissaoPorID(@PathVariable Long id) {
        return missaoService.buscarPorId(id);
    }

    //PUT - Enviar requisição para atualizar Missão por ID
    @PutMapping("/atualizar")
    public String atualizarMissao() {
        return "Missão atualizada com sucesso!";
    }

    //DELETE - Enviar requisição para excluir Missão por ID
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso!";
    }
}
