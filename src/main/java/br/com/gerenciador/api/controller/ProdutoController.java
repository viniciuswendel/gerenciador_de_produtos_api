package br.com.gerenciador.api.controller;

import br.com.gerenciador.api.dto.ProdutoRequestDTO;
import br.com.gerenciador.api.dto.ProdutoResponseDTO;
import br.com.gerenciador.api.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@Valid @RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.status(201).body(produtoService.criarProduto(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodosFornecedores() {
        return ResponseEntity.ok(produtoService.listarTodosProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPeloId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarProdutoPeloId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProdutoPeloId(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.ok(produtoService.atualizarProdutoPeloId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPeloId(@PathVariable Long id) {
        produtoService.deletarProdutoPeloId(id);
        return ResponseEntity.noContent().build();
    }
}
