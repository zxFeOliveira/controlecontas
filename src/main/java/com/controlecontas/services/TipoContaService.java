package com.controlecontas.services;

import com.controlecontas.domains.TipoConta;
import com.controlecontas.dtos.TipoContaDTO;
import com.controlecontas.exceptions.TipoContaNotFoundException;
import com.controlecontas.repositories.ContaRepository;
import com.controlecontas.repositories.TipoContaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoContaService {

    private final TipoContaRepository tipoContaRepository;
    private final ContaRepository contaRepository;

    public TipoContaService(TipoContaRepository tipoContaRepository, ContaRepository contaRepository){
        this.tipoContaRepository = tipoContaRepository;
        this.contaRepository = contaRepository;
    }

    public TipoConta createTipoConta(TipoContaDTO data){
        TipoConta newTipoConta = new TipoConta(data);
        return tipoContaRepository.save(newTipoConta);
    }

    public List<TipoConta> getAllTipoConta(){
        return this.tipoContaRepository.findAll();
    }

    public void deleteTipoConta(Long id) {
        TipoContaExiste(id);

        if (contaRepository.existsByTipo_Id(id)) {
            throw new IllegalStateException(
                    "Não é possível excluir o TipoConta pois existem contas associadas."
            );
        }

        tipoContaRepository.deleteById(id);
    }

    private void TipoContaExiste(Long id){
        if (!tipoContaRepository.existsById(id)) {
            throw new TipoContaNotFoundException(id);
        }
    }
}
