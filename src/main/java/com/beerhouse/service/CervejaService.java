package com.beerhouse.service;

import com.beerhouse.entity.CervejaEntity;
import com.beerhouse.exception.ProdutoExistenteException;
import com.beerhouse.exception.ProdutoInexistenteException;
import com.beerhouse.repository.CervejaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
@Scope("singleton")
public class CervejaService {

    @Autowired
    private CervejaRepository cervejaRepository;

    public List<CervejaEntity> listar() {

        return cervejaRepository.findAll();
    }

    public Optional<CervejaEntity> buscarPorMarca(String marca) {
        return Optional.ofNullable(cervejaRepository.findByMarca(marca)
                .orElseThrow(() -> new ProdutoInexistenteException("Produto inexistente" + marca)));
    }

    @Transactional
    public CervejaEntity salvar(CervejaEntity cervejaEntity) {

        Optional<CervejaEntity> cervejaExiste = cervejaRepository.findByMarca(cervejaEntity.getMarca());
        try {
            if (cervejaExiste.isPresent()) {
                cervejaRepository.save(cervejaEntity);
            }
        } catch (final ProdutoExistenteException e) {
            log.debug(e.getMessage());
        }
        return cervejaEntity;
    }

    @Transactional
    public void atualizar(CervejaEntity cervejaEntity, Long id) {

        try {
            if (cervejaRepository.findById(id).isPresent()) {
                cervejaEntity.setId(id);
                cervejaRepository.saveAndFlush(cervejaEntity);
            }
        } catch (ProdutoInexistenteException e) {
            log.debug(e.getMessage());
        }
    }

    @Transactional
    public void deletar(Long id) {

        try {
            if (cervejaRepository.findById(id).isEmpty()) {
                cervejaRepository.deleteById(id);
            }
        } catch (ProdutoInexistenteException e) {
            log.debug(e.getMessage());
        }
    }
}
