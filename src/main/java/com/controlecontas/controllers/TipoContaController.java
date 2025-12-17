package com.controlecontas.controllers;

import com.controlecontas.domains.TipoConta;
import com.controlecontas.dtos.TipoContaDTO;
import com.controlecontas.services.TipoContaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoconta")
public class TipoContaController {

    private TipoContaService tipoContaService;

    public TipoContaController(TipoContaService tipoContaService){
        this.tipoContaService = tipoContaService;
    }

    @PostMapping
    public ResponseEntity<TipoConta> createTipoConta(
            @RequestBody @Valid TipoContaDTO tipoContaDTO){
        TipoConta newTipoConta = tipoContaService.createTipoConta(tipoContaDTO);
        return new ResponseEntity<>(newTipoConta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TipoConta>> getAllTipoConta(){
        List<TipoConta> tipoContas = this.tipoContaService.getAllTipoConta();
        return new ResponseEntity<>(tipoContas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tipoContaService.deleteTipoConta(id);
    }
}
