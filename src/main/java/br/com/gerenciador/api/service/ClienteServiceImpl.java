package br.com.gerenciador.api.service;

import br.com.gerenciador.api.dto.ClienteRequestDTO;
import br.com.gerenciador.api.dto.ClienteResponseDTO;
import br.com.gerenciador.api.mapper.ClienteMapper;
import br.com.gerenciador.api.mapper.EnderecoMapper;
import br.com.gerenciador.api.model.Cliente;
import br.com.gerenciador.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final EnderecoMapper enderecoMapper;

    @Override
    public ClienteResponseDTO criarCliente(ClienteRequestDTO dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        return clienteMapper.toDTO(clienteRepository.save(cliente));
    }

    @Override
    public List<ClienteResponseDTO> listarTodosClientes() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toDTO)
                .toList();
    }

    @Override
    public ClienteResponseDTO buscarClientePeloId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"));
        return clienteMapper.toDTO(cliente);
    }

    @Transactional
    @Override
    public ClienteResponseDTO atualizarClientePeloId(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"));
        cliente.setNome(dto.nome());
        cliente.setCpf(dto.cpf());
        cliente.setEmail(dto.email());
        cliente.setEndereco(enderecoMapper.toEntity((dto.endereco())));

        clienteRepository.save(cliente);

        return  clienteMapper.toDTO(cliente);
    }

    @Transactional
    @Override
    public void deletarClientePeloId(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

        clienteRepository.deleteById(id);
    }
}
