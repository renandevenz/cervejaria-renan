package com.beerhouse.service;

import com.beerhouse.domain.Cerveja;
import com.beerhouse.repository.CervejaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
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
        Optional<Cerveja> cervejaExiste = cervejaRepository.findByMarca(cerveja.getMarca());

        return cervejaRepository.save(cerveja);
    }

    public Cerveja atualizar(Cerveja cerveja, Long id) {
        if (cervejaRepository.findById(id).isPresent()) {
            cerveja.setId(id);
            return cervejaRepository.saveAndFlush(cerveja);
        } throw new IllegalArgumentException("Não existe um produto para atualizar");
    }

    public void deletar(Long id) {
        if (cervejaRepository.findById(id).isPresent()) {
            cervejaRepository.deleteById(id);
        } throw new IllegalArgumentException("Não existe um produto para remover");
    }
}
