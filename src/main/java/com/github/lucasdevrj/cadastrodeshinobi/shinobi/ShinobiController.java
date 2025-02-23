package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.web.bind.annotation.*;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping("/shinobis") //rota da qual acessaremos a API
public class ShinobiController {

    @GetMapping("/boasvindas") //pegar informação passada pelo método
    public String boasVindas() {
        return "Seja bem-vindo Shinobi!";
    }

    //Adicionar Shinobi
    @PostMapping("/adicionar") //enviar informação passada pelo método
    public String adicionarShinobi() {
        return "O Shinobi foi adicionado com sucesso!";
    }

    //Procurar Shinobi por ID
    @GetMapping("/exibirPorID")
    public String exibirShinobiPorID() {
        return "Shinobi exibido com sucesso!";
    }

    //Exibir todos os Shinobis
    @GetMapping("/listar")
    public String exibirShinobis() {
        return "Todos os Shinobis exibidos com sucesso!";
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
