package com.exo1.exo1.service;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.entity.Projet;
import com.exo1.exo1.mapper.ProjetMapper;
import com.exo1.exo1.repository.TaskRepository;
import com.exo1.exo1.repository.ProjetRepository;


import org.springframework.cache.annotation.Cacheable;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
@AllArgsConstructor
public class ProjetService {
    private final ProjetRepository projetRepository;
    private final ProjetMapper projetMapper;
    private final TaskRepository taskRepository;

    @Cacheable(value = "projects", key = "#id")
    public Projet getProjetById(Long id) {
        return projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet not found")); // Correct handling of exception
    }

    public ProjetDto save(ProjetDto projetDto) {
        Projet projet = projetMapper.toEntity(projetDto);
        projet.getTasks().forEach(t -> t.setProjet(projet));
        return projetMapper.toDto(projetRepository.save(projet));
    }

    @CacheEvict(value = "projects", key = "#projet.id")
    public ProjetDto update(Long id, ProjetDto projetDto) {
        Projet existingProjet = projetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Projet not found with id " + id));
        projetDto.setId(existingProjet.getId());
        Projet projetUpdated = projetMapper.toEntity(projetDto);
        projetUpdated.getTasks().forEach(t -> {
            if (taskRepository.existsById(t.getId())) {
                t.setProjet(projetUpdated);
            }
        });
        return projetMapper.toDto(projetRepository.save(projetUpdated));
    }

    @CacheEvict(value = "projects", key = "#id")
    public void delete(Long id) {
        projetRepository.deleteById(id);
    }

    public Page<Projet> getAllProjets(Pageable pageable) {
        return projetRepository.findAll(pageable);
    }
}

