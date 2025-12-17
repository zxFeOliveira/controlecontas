package com.controlecontas.repositories;

import com.controlecontas.domains.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoContaRepository extends JpaRepository<TipoConta, Long> {
}
