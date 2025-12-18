package com.controlecontas.services;

import com.controlecontas.domains.Conta;
import com.controlecontas.domains.TipoConta;
import com.controlecontas.dtos.ContaDTO;
import com.controlecontas.dtos.ContaResponseDTO;
import com.controlecontas.enums.StatusConta;
import com.controlecontas.repositories.ContaRepository;
import com.controlecontas.repositories.TipoContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private ContaRepository contaRepository;
    private final TipoContaRepository tipoContaRepository;

    public ContaService(ContaRepository contaRepository, TipoContaRepository tipoContaRepository){
        this.contaRepository = contaRepository;
        this.tipoContaRepository = tipoContaRepository;
    }

    public Conta createConta(ContaDTO data){

        TipoConta tipo = tipoContaRepository.findById(data.tipoConta().getId())
                .orElseThrow(() -> new RuntimeException("Tipo de conta não encontrado"));

        Conta newConta = new Conta(data);
        newConta.setTipo(tipo);

        return contaRepository.save(newConta);
    }

    public List<Conta> getAllContas (){
        return this.contaRepository.findAll();
    }

    public Conta findById(Long id){
        return contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public void deleteConta(Long id) {
        if (!contaRepository.existsById(id)) {
            throw new RuntimeException("Conta não encontrada");
        }
        contaRepository.deleteById(id);
    }

    public Conta updateVencimento(Long id, LocalDate novoVencimento) {
        Conta conta = this.findById(id);
        conta.setVencimento(novoVencimento);
        return contaRepository.save(conta);
    }

    public Conta updateValor(Long id, BigDecimal novoValor) {
        Conta conta = this.findById(id);
        conta.setValor(novoValor);
        return contaRepository.save(conta);
    }

    public Conta updateStatus(Long id, StatusConta novoStatus) {
        Conta conta = this.findById(id);
        conta.setStatusConta(novoStatus);
        return contaRepository.save(conta);
    }

    private void atualizarStatusAutomatico(Conta conta){
        if (
                conta.getStatusConta() == StatusConta.PENDENTE &&
                        conta.getVencimento().isBefore(LocalDate.now())
        ) {
            conta.setStatusConta(StatusConta.ATRASADA);
        }
    }

    private void atualizarContasAtrasadas(){
        List<Conta> pendentes = contaRepository.findByStatusConta(StatusConta.PENDENTE);
        pendentes.forEach(this::atualizarStatusAutomatico);
    }

    public ContaResponseDTO toResponseDTO(Conta conta) {
        return new ContaResponseDTO(
                conta.getId(),
                conta.getNome(),
                conta.getObservacao(),
                conta.getValor(),
                conta.getVencimento(),
                conta.getStatusConta().name(),
                conta.getTipo().getNome()
        );
    }
}
