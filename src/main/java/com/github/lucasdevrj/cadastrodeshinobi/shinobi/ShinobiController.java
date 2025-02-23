package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.web.bind.annotation.*;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping //rota da qual acessaremos a API
public class ShinobiController {

    @GetMapping("/boasvindas") //pegar informação passada pelo método
    public String boasVindas() {
        return "Seja bem-vindo Shinobi!";
    }

    //Adicionar Shinobi
    @PostMapping("/adicionarShinobi") //enviar informação passada pelo método
    public String adicionarShinobi() {
        return "O Shinobi foi adicionado com sucesso!";
    }

    //Procurar Shinobi por ID
    @GetMapping("/exibirShinobiPorID")
    public String exibirShinobiPorID() {
        return "Shinobi exibido com sucesso!";
    }

    //Exibir todos os Shinobis
    @GetMapping("/exibirShinobis")
    public String exibirShinobis() {
        return "Todos os Shinobis exibidos com sucesso!";
    }

    //Atualizar Shinobi
    @PutMapping("/atualizarShinobi") //atualizar informação passada pelo método
    public String atualizarShinobi() {
        return "Atualizado com sucesso!";
    }

    //Deleter Shinobi
    @DeleteMapping("/deletarShinobiPorID") //deletar informação passada pelo método
    public String deletarShinobiPorID() {
        return "Shinobi deletado com sucesso!";
    }
}
