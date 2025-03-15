package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
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
    public ResponseEntity<String> adicionarShinobi(@RequestBody ShinobiDTO shinobi) {
        ShinobiDTO shinobiAdicionado = shinobiService.adicionarShinobi(shinobi);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Shinobi adicionado com sucesso: " + shinobiAdicionado.getNome());
    }

    //Procurar Shinobi por ID
    @GetMapping("/exibirPorID/{id}") //ID será passada pelo usuário
    public ShinobiDTO exibirShinobiPorID(@PathVariable Long id) {
        return shinobiService.exibirShinobiPorID(id);
    }

    //Exibir todos os Shinobis
    @GetMapping("/listar")
    public List<ShinobiDTO> listarShinobis() {
        return shinobiService.listarShinobis();
    }

    //Atualizar Shinobi
    @PutMapping("/atualizar/{id}") //atualizar informação passada pelo método
    public ResponseEntity<String> atualizarShinobi(@PathVariable Long id, @RequestBody ShinobiDTO shinobiAtualizado) {
        if (shinobiService.exibirShinobiPorID(id) != null) {
            shinobiService.atualizar(id, shinobiAtualizado);
            return ResponseEntity.ok("O Shinobi " + shinobiAtualizado.getNome() + " atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shinobi inexistente!");
    }

    //@PathVariable pega o valor digitado pelo usuário
    //Deleter Shinobi
    @DeleteMapping("/deletar/{id}") //deletar informação passada pelo método
    public ResponseEntity<String> deletarShinobiPorID(@PathVariable Long id) {
        if (shinobiService.exibirShinobiPorID(id) != null) {
            ShinobiDTO shinobiDeletado = shinobiService.exibirShinobiPorID(id);
            shinobiService.deletarShinobiPorID(id);
            return ResponseEntity.ok("O Shinobi " + shinobiDeletado.getNome() + " foi deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shinobi inexistente!");
        }
    }
}
