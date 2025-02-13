package com.github.lucasdevrj.cadastrodeshinobi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping //rota da qual acessaremos a API
public class Controller {

    @GetMapping("/boasvindas") //pegar informação passada pelo método
    public String boasVindas() {
        return "Boas vindas";
    }
}
