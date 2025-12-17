package com.controlecontas.domains;

import com.controlecontas.dtos.ContaDTO;
import com.controlecontas.enums.StatusConta;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "observacao")
    private String observacao;
    private BigDecimal valor;
    private LocalDate vencimento;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoConta tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConta statusConta;

    public Conta(ContaDTO data){
        this.nome = data.nome();
        this.observacao = data.observacao();
        this.valor = data.valor();
        this.vencimento = data.vencimento();
        this.tipo = data.tipoConta();
        this.statusConta = StatusConta.PENDENTE;
    }
}
