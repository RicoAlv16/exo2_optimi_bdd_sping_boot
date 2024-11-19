package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Projet;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {

    // Précharger les relations nécessaires pour éviter Query N+1
    @EntityGraph(attributePaths = {"tasks", "users"})
    Optional<Projet> findById(Long id);

    // Charger tous les projets avec leurs relations (si besoin)
    @EntityGraph(attributePaths = {"tasks", "users"})
    List<Projet> findAll();

    @EntityGraph(attributePaths = {"tasks", "users"})
    Page<Projet> findAll(Pageable pageable);
}
