package com.controlecontas.controllers;

import com.controlecontas.domains.Conta;
import com.controlecontas.dtos.*;
import com.controlecontas.services.ContaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    public final ContaService contaService;

    public ContaController (ContaService contaService){
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<ContaResponseDTO> createConta(@RequestBody @Valid ContaDTO contaDTO){
        Conta newConta = contaService.createConta(contaDTO);
        return new ResponseEntity<>(contaService.toResponseDTO(newConta), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContaResponseDTO>> getAllContas(){
        List<ContaResponseDTO> response = contaService.getAllContas()
                .stream()
                .map(contaService::toResponseDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        contaService.deleteConta(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/vencimento")
    public ResponseEntity<ContaResponseDTO> updateVencimento(
            @PathVariable Long id,
            @RequestBody @Valid AtualizarVencimentoDTO dto
    ){
        Conta conta = contaService.updateVencimento(id, dto.vencimento());
        return ResponseEntity.ok(contaService.toResponseDTO(conta));
    }

    @PatchMapping("/{id}/valor")
    public ResponseEntity<ContaResponseDTO> updateValor(
            @PathVariable Long id,
            @RequestBody @Valid AtualizarValorDTO dto
    ){
        Conta conta = contaService.updateValor(id, dto.valor());
        return ResponseEntity.ok(contaService.toResponseDTO(conta));
    }

    // PATCH - status
    @PatchMapping("/{id}/status")
    public ResponseEntity<ContaResponseDTO> updateStatus(
            @PathVariable Long id,
            @RequestBody @Valid AtualizarStatusDTO dto
    ){
        Conta conta = contaService.updateStatus(id, dto.status());
        return ResponseEntity.ok(contaService.toResponseDTO(conta));
    }


}
