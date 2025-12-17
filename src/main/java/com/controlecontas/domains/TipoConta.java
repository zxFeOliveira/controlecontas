package com.controlecontas.domains;

import com.controlecontas.dtos.TipoContaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "tipo")
    @JsonIgnore
    private List<Conta> contas;

    public TipoConta(TipoContaDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
    }
}
