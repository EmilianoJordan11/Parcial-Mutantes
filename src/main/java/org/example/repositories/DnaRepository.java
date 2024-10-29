package org.example.repositories;

import org.example.entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long>{
    Optional<Dna> findByDna(String[] dna);

    long countByIsMutant(boolean isMutant);

}
