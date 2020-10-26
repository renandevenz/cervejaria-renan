package com.beerhouse.repository;

import com.beerhouse.domain.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

    Optional<Cerveja> findById(Long id);
    Optional<Cerveja> findByMarca(String marca);
}
