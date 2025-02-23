package com.github.lucasdevrj.cadastrodeshinobi.missao;

import org.springframework.web.bind.annotation.*;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping("missoes")//rota da qual acessaremos a API
public class MissaoController {

    //POST - Enviar requisição para criar uma Missão
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso!";
    }

    //GET - Enviar requisição para listar Missões
    @GetMapping("/listar")
    public String exibirMissoes() {
        return "Missões listadas!";
    }

    //GET - Enviar requisição para exibir Missão por ID
    @GetMapping("/exibirPorID")
    public String exibirMissaoPorID() {
        return "Missão exibida com sucesso!";
    }

    //PUT - Enviar requisição para atualizar Missão por ID
    @PutMapping("/atualizar")
    public String atualizarMissao() {
        return "Missão atualizada com sucesso!";
    }

    //DELETE - Enviar requisição para excluir Missão por ID
    @DeleteMapping("/excluir")
    public String excluirMissao() {
        return "Missão deletada com sucesso!";
    }
}
