package br.com.gerenciador.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table (name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome", nullable = false, length = 100)
    private String nome;

    @Column (name = "cpf", nullable = false, unique = true, length = 11, updatable = false)
    private String cpf;

    @Column (name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @OneToOne(cascade = CascadeType.ALL) // se deletar o cliente o endereço vai junto
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Column(name = "criado_em", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime autalizadoEm;
}
