package br.com.gerenciador.api.mapper;

import br.com.gerenciador.api.dto.FornecedorRequestDTO;
import br.com.gerenciador.api.dto.FornecedorResponseDTO;
import br.com.gerenciador.api.model.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {

    // Conversor de DTO para Entidade:
    @Mapping(target = "id", ignore = true)
    Fornecedor toEntity (FornecedorRequestDTO dto);

    // Conversor da Entidade para o DTO:
    FornecedorResponseDTO toDTO (Fornecedor fornecedor);

}
