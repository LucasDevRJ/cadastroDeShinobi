package com.github.lucasdevrj.cadastrodeshinobi.missao;

import com.github.lucasdevrj.cadastrodeshinobi.shinobi.ShinobiModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping("/missoes")//rota da qual acessaremos a API
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    //Adicionar Shinobi
    @PostMapping("/adicionar") //enviar informação passada pelo método
    //RequestBody envia requisições pelo corpo do conteúdo
    //Desearalização(Da web para o Banco de Dados)
    public MissaoModel adicionarMissao(@RequestBody MissaoModel missao) {
        return missaoService.adicionar(missao);
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
    @PutMapping("/atualizar/{id}")
    public MissaoModel atualizarMissao(@PathVariable Long id, @RequestBody MissaoModel missao) {
        return missaoService.atualizar(id, missao);
    }

    //DELETE - Enviar requisição para excluir Missão por ID
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletar(id);
    }
}
