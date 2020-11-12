package com.beerhouse.service;

import com.beerhouse.entity.CervejaEntity;
import com.beerhouse.repository.CervejaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
public class CervejaService {

    @Autowired
    private CervejaRepository cervejaRepository;

    public List<CervejaEntity> listar() {
        return cervejaRepository.findAll();
    }

    public Optional<CervejaEntity> buscarPorMarca(String marca) {
        return Optional.ofNullable(cervejaRepository.findByMarca(marca)
                .orElseThrow(() -> new IllegalArgumentException("Produto inexistente")));
    }

    @Transactional
    public CervejaEntity salvar(CervejaEntity cervejaEntity) {
        Optional<CervejaEntity> cervejaExiste = cervejaRepository.findByMarca(cervejaEntity.getMarca());

        return cervejaRepository.save(cervejaEntity);
    }

    @Transactional
    public CervejaEntity atualizar(CervejaEntity cervejaEntity, Long id) {
        if (cervejaRepository.findById(id).isPresent()) {
            cervejaEntity.setId(id);
            return cervejaRepository.saveAndFlush(cervejaEntity);
        } throw new IllegalArgumentException("Não existe um produto para atualizar");
    }

    @Transactional
    public void deletar(Long id) {
        if (cervejaRepository.findById(id).isEmpty()) {
            cervejaRepository.deleteById(id);
        } throw new IllegalArgumentException("Não existe um produto para remover");
    }
}
