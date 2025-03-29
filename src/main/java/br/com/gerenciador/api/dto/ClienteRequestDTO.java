package br.com.gerenciador.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100)
        String nome,

        @CPF
        String cpf,

        @Email(message = "Email inválido")
        String email,

        @Valid
        EnderecoDTO endereco
) {
}
