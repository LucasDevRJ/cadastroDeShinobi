package com.github.lucasdevrj.cadastrodeshinobi.missao;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Adição de Missão", description = "Essa rota adiciona uma Missão baseada nos dados informados pelo usuário.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao criar Missão.")
    })
    public ResponseEntity<String> adicionarMissao(
            @Parameter(description = "O usuário envia os dados da Missão via requisição.") @RequestBody MissaoDTO missao
    ) {
        MissaoDTO missaoAdicionada = missaoService.adicionar(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão adicionada com sucesso: " + missaoAdicionada.getNome());
    }

    //GET - Enviar requisição para exibir Missão por ID
    @GetMapping("/exibirPorID/{id}")
    @Operation(summary = "Exibe Missão", description = "Essa rota permite a exibição de uma Missão via ID na requisição.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão exibida com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir Missão.")
    })
    public ResponseEntity<?> exibirMissaoPorID(
            @Parameter(description = "Usuário encaminha o ID da Missão via requisição.") @PathVariable Long id
    ) {
        MissaoDTO missao = missaoService.exibirMissaoPorID(id);
        if (missao != null) {
            return ResponseEntity.status(HttpStatus.OK).body(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " é inexistente.");
        }
    }

    @GetMapping("/listarMissoes")
    @Operation(summary = "Listar Missões cadastrados", description = "Essa rota lista todos as Missões cadastradas.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missões listados com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao listar Missões.")
    })
    public ResponseEntity<List<MissaoDTO>> listarMissoes() {
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //PUT - Enviar requisição para atualizar Missão por ID
    @PutMapping("/atualizarMissao/{id}")
    @Operation(summary = "Atualiza Shinobi por ID", description = "Essa rota atualiza os dados do Shinobi pelo seu ID.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shinobi atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao atualizar Shinobi.")
    })
    public ResponseEntity<String> atualizarShinobi(
            @Parameter(description = "Usuário encaminha o ID da Missão via requisição.") @PathVariable Long id,
            @Parameter(description = "Usuário envia os dados da Missão a ser atualizada no corpo da requisição.") @RequestBody MissaoDTO missaoDTO
    ) {
        if (missaoService.exibirMissaoPorID(id) != null) {
            missaoService.atualizar(id, missaoDTO);
            return ResponseEntity.ok("A Missão" + missaoDTO.getNome() + " foi atualizada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " é inexistente.");
        }
    }
    //DELETE - Enviar requisição para excluir Missão por ID
    @DeleteMapping("/deletarMissao/{id}")
    @Operation(summary = "Deleta Missão por ID", description = "Essa rota deleta a Missão pelo seu ID.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao deletar Missão.")
    })
    public ResponseEntity<String> deletarShinobiPorID(
            @Parameter(description = "Usuário encaminha o ID da Missão via requisição.") @PathVariable Long id
    ) {
        if (missaoService.exibirMissaoPorID(id) != null) {
            MissaoDTO shinobiDeletado = missaoService.exibirMissaoPorID(id);
            missaoService.deletar(id);
            return ResponseEntity.ok("A Missão " + shinobiDeletado.getNome() + " foi deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " é inexistente.");
        }
    }
}
