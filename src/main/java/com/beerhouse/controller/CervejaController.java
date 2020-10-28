package com.beerhouse.controller;

import com.beerhouse.domain.Cerveja;
import com.beerhouse.entity.CervejaEntity;
import com.beerhouse.mapper.CervejaMapper;
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
    public ResponseEntity<List<CervejaEntity>> listar() {
        return ResponseEntity.ok(cervejaService.listar());
    }

    @GetMapping("/{marca}")
    public ResponseEntity<CervejaEntity> buscarPorMarca(@PathVariable String marca) {
        Optional<CervejaEntity> cerveja = cervejaService.buscarPorMarca(marca);

        return cerveja.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CervejaEntity> cadastrar(@Valid @RequestBody CervejaMapper cervejaMapper,
                                                   Cerveja cerveja) {
        CervejaEntity cervejaEntity = cervejaService.salvar(CervejaMapper.convert(cerveja));

        return new ResponseEntity<>(cervejaEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CervejaEntity> atualizar(@PathVariable Long id, @RequestBody CervejaEntity cervejaEntity) {
        cervejaService.atualizar(cervejaEntity, id);
        return ResponseEntity.ok(cervejaEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CervejaEntity> remover(@PathVariable Long id) {
        cervejaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
