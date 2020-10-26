package com.beerhouse.service;

import com.beerhouse.domain.Cerveja;
import com.beerhouse.repository.CervejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CervejaService {

    @Autowired
    private CervejaRepository cervejaRepository;

    public List<Cerveja> listar() {
        return cervejaRepository.findAll();
    }

    public Optional<Cerveja> buscarPorMarca(String marca) {
        return Optional.ofNullable(cervejaRepository.findByMarca(marca)
                .orElseThrow(() -> new IllegalArgumentException("Produto inexistente")));
    }

    public Cerveja salvar(Cerveja cerveja) {
        return cervejaRepository.save(cerveja);
    }

    public Cerveja atualizar(Cerveja cerveja, Long id) {
        if (cervejaRepository.findById(id).isPresent()) {
            return cervejaRepository.saveAndFlush(cerveja);
        } throw new IllegalArgumentException("Não existe um produto para atualizar");
    }

    public void deletar(Long id) {
        cervejaRepository.deleteById(id);
    }
}
