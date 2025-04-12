package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica para a classe que ela é uma Controladora para a API
@RequestMapping("/shinobis") //rota da qual acessaremos a API
public class ShinobiController {

    private final ShinobiService shinobiService;

    public ShinobiController(ShinobiService shinobiService) {
        this.shinobiService = shinobiService;
    }

    //Adicionar Shinobi
    @PostMapping("/adicionarShinobi") //enviar informação passada pelo método
    //RequestBody envia requisições pelo corpo do conteúdo
    //Desearalização(Da web para o Banco de Dados)
    @Operation(summary = "Adição de Shinobi", description = "Essa rota adiciona um Shinobi baseado nos dados informados pelo usuário.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Shinobi criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao criar Shinobi.")
    })
    public ResponseEntity<String> adicionarShinobi(
            @Parameter(description = "O usuário envia os dados do Shinobi via requisição.") @RequestBody ShinobiDTO shinobi
    ) {
        ShinobiDTO shinobiAdicionado = shinobiService.adicionarShinobi(shinobi);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Shinobi adicionado com sucesso: " + shinobiAdicionado.getNome());
    }

    //Procurar Shinobi por ID
    //? significa que é Generic, ou seja, pode usar vários tipos de classes distintas
    @GetMapping("/exibirShinobiPorID/{id}") //ID será passada pelo usuário
    @Operation(summary = "Exibe Shinobi por ID", description = "Essa rota exibe dados de um Shinobi pelo ID dele.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shinobi exibido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao exibir Shinobi.")
    })
    public ResponseEntity<?> exibirShinobiPorID(
            @Parameter(description = "Usuário encaminha o ID do Shinobi via requisição.") @PathVariable Long id
    ) {
        ShinobiDTO shinobi = shinobiService.exibirShinobiPorID(id);
        if (shinobi != null) {
            return ResponseEntity.status(HttpStatus.OK).body(shinobi);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shinobi com ID " + id + " é inexistente.");
        }
    }

    //Exibir todos os Shinobis
    @GetMapping("/listarShinobis")
    @Operation(summary = "Listar Shinobis cadastrados", description = "Essa rota lista todos os Shinobis cadastrados.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shinobis listados com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao listar Shinobis.")
    })
    public ResponseEntity<List<ShinobiDTO>> listarShinobis() {
        List<ShinobiDTO> shinobis = shinobiService.listarShinobis();
        return ResponseEntity.ok(shinobis);
    }

    //Atualizar Shinobi
    @PutMapping("/atualizarShinobi/{id}") //atualizar informação passada pelo método
    @Operation(summary = "Atualiza Shinobi por ID", description = "Essa rota atualiza os dados do Shinobi pelo seu ID.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shinobi atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Erro ao atualizar Shinobi.")
    })
    public ResponseEntity<String> atualizarShinobi(
            @Parameter(description = "Usuário encaminha o ID do Shinobi via requisição.") @PathVariable Long id,
            @Parameter(description = "Usuário envia os dados do Shinobi a ser atualizado no corpo da requisição.") @RequestBody ShinobiDTO shinobiAtualizado) {
        if (shinobiService.exibirShinobiPorID(id) != null) {
            shinobiService.atualizar(id, shinobiAtualizado);
            return ResponseEntity.ok("O Shinobi " + shinobiAtualizado.getNome() + " atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shinobi com ID " + id + " é inexistente.");
        }
    }

    //@PathVariable pega o valor digitado pelo usuário
    //Deleter Shinobi
    @DeleteMapping("/deletarShinobi/{id}") //deletar informação passada pelo método
    @Operation(summary = "Deleta Shinobi por ID", description = "Essa rota deleta o Shinobi pelo seu ID.") //adição da documentação do Swagger
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shinobi deletado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao deletar Shinobi.")
    })
    public ResponseEntity<String> deletarShinobiPorID(
            @Parameter(description = "Usuário encaminha o ID do Shinobi via requisição.") @PathVariable Long id
    ) {
        if (shinobiService.exibirShinobiPorID(id) != null) {
            ShinobiDTO shinobiDeletado = shinobiService.exibirShinobiPorID(id);
            shinobiService.deletarShinobiPorID(id);
            return ResponseEntity.ok("O Shinobi " + shinobiDeletado.getNome() + " foi deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shinobi com ID " + id + " é inexistente.");
        }
    }
}
