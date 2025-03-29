package br.com.gerenciador.api.service;

import br.com.gerenciador.api.dto.ProdutoRequestDTO;
import br.com.gerenciador.api.dto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {
    ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto);
    List<ProdutoResponseDTO> listarTodosProdutos();
    ProdutoResponseDTO buscarProdutoPeloId(Long id);
    ProdutoResponseDTO atualizarProdutoPeloId(Long id, ProdutoRequestDTO dto);
    void deletarProdutoPeloId(Long id);
}
