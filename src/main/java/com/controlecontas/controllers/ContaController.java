package com.controlecontas.controllers;

import com.controlecontas.domains.Conta;
import com.controlecontas.dtos.ContaDTO;
import com.controlecontas.dtos.ContaResponseDTO;
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
    public List<Conta> getAllContas(){
        return contaService.getAllContas();
    }
}
