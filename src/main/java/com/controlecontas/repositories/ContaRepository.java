package com.controlecontas.repositories;

import com.controlecontas.domains.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    boolean existsByTipo_Id(Long id);
}
