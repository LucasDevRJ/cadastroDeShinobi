package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping("/shinobis") //rota da qual acessaremos a API
public class ShinobiController {

    private ShinobiService shinobiService;

    public ShinobiController(ShinobiService shinobiService) {
        this.shinobiService = shinobiService;
    }

    @GetMapping("/boasvindas") //pegar informação passada pelo método
    public String boasVindas() {
        return "Seja bem-vindo Shinobi!";
    }

    //Adicionar Shinobi
    @PostMapping("/adicionar") //enviar informação passada pelo método
    //RequestBody envia requisições pelo corpo do conteúdo
    //Desearalização(Da web para o Banco de Dados)
    public ShinobiModel adicionarShinobi(@RequestBody ShinobiModel shinobi) {
        return shinobiService.adicionarShinobi(shinobi);
    }

    //Procurar Shinobi por ID
    @GetMapping("/exibirPorID/{id}") //ID será passada pelo usuário
    public ShinobiModel exibirShinobiPorID(@PathVariable Long id) {
        return shinobiService.exibirNinjaPorID(id);
    }

    //Exibir todos os Shinobis
    @GetMapping("/listar")
    public List<ShinobiModel> listarShinobis() {
        return shinobiService.listarShinobis();
    }

    //Atualizar Shinobi
    @PutMapping("/atualizar") //atualizar informação passada pelo método
    public String atualizarShinobi() {
        return "Atualizado com sucesso!";
    }

    //Deleter Shinobi
    @DeleteMapping("/deletar") //deletar informação passada pelo método
    public String deletarShinobiPorID() {
        return "Shinobi deletado com sucesso!";
    }
}
