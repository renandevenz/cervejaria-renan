package com.beerhouse.output.adapter.entity.repository;

import com.beerhouse.output.adapter.entity.CervejaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CervejaRepository extends JpaRepository<CervejaEntity, Long> {

    Optional<CervejaEntity> findById(Long id);
    Optional<CervejaEntity> findByMarca(String marca);
}
