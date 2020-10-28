package com.beerhouse.controller;

import com.beerhouse.domain.Cerveja;
import com.beerhouse.dto.CervejaDTO;
import com.beerhouse.service.CervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/craftbeer")
public class CervejaController {

    @Autowired
    private CervejaService cervejaService;

    @GetMapping
    public ResponseEntity<List<Cerveja>> listar() {
        return ResponseEntity.ok(cervejaService.listar());
    }

    @GetMapping("/{marca}")
    public ResponseEntity<Cerveja> buscarPorMarca(@PathVariable String marca) {
        Optional<Cerveja> cerveja = cervejaService.buscarPorMarca(marca);

        return cerveja.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cerveja> cadastrar(@Valid @RequestBody CervejaDTO cervejaDTO) {
        Cerveja cerveja = cervejaService.salvar(cervejaDTO.cervejaMapper());

        return new ResponseEntity<>(cerveja, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cerveja> atualizar(@PathVariable Long id, @RequestBody Cerveja cerveja) {
        cervejaService.atualizar(cerveja, id);
        return ResponseEntity.ok(cerveja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cerveja> remover(@PathVariable Long id) {
        cervejaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
