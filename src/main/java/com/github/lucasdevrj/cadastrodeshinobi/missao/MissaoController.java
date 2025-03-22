package com.github.lucasdevrj.cadastrodeshinobi.missao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping("/missoes")//rota da qual acessaremos a API
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    //GET - Enviar requisição para listar Missões
    @PostMapping("/adicionaMissao")
    public ResponseEntity<String> adicionarMissao(@RequestBody MissaoDTO missao) {
        MissaoDTO missaoAdicionada = missaoService.adicionar(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão adicionada com sucesso: " + missaoAdicionada.getNome());
    }

    //GET - Enviar requisição para exibir Missão por ID
    @GetMapping("/exibirPorID/{id}")
    public ResponseEntity<?> exibirMissaoPorID(@PathVariable Long id) {
        MissaoDTO missao = missaoService.exibirMissaoPorID(id);
        if (missao != null) {
            return ResponseEntity.status(HttpStatus.OK).body(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " é inexistente.");
        }
    }

    @GetMapping("/listarMissoes")
    public ResponseEntity<List<MissaoDTO>> listarMissoes() {
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //PUT - Enviar requisição para atualizar Missão por ID
    @PutMapping("/atualizarMissao/{id}")
    public ResponseEntity<String> atualizarShinobi(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO) {
        if (missaoService.exibirMissaoPorID(id) != null) {
            missaoService.atualizar(id, missaoDTO);
            return ResponseEntity.ok("A Missão" + missaoDTO.getNome() + " foi atualizada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " é inexistente.");
        }
    }
    //DELETE - Enviar requisição para excluir Missão por ID
    @DeleteMapping("/deletarMissao/{id}")
    public ResponseEntity<String> deletarShinobiPorID(@PathVariable Long id) {
        if (missaoService.exibirMissaoPorID(id) != null) {
            MissaoDTO shinobiDeletado = missaoService.exibirMissaoPorID(id);
            missaoService.deletar(id);
            return ResponseEntity.ok("A Missão " + shinobiDeletado.getNome() + " foi deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " é inexistente.");
        }
    }
}
