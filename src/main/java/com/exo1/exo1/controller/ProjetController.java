package com.exo1.exo1.controller;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.mapper.ProjetMapper;
import com.exo1.exo1.entity.Projet;
import com.exo1.exo1.service.ProjetService;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;
    @Autowired
    private ProjetMapper projetMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProjetDto> getProjet(@PathVariable Long id) {
        Projet projet = projetService.getProjetById(id);
        ProjetDto projetDto = projetMapper.toDto(projet);
        return ResponseEntity.ok(projetDto);
    }

    @PostMapping
    public ResponseEntity<ProjetDto> save(@Valid @RequestBody ProjetDto projetDto) {
        return ResponseEntity.ok(projetService.save(projetDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetDto> update(@PathVariable Long id, @Valid @RequestBody ProjetDto projetDto) {
        return ResponseEntity.ok(projetService.update(id, projetDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projetService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public Page getAllProjects(Pageable pageable) {
        return (Page) projetService.getAllProjets(pageable);
    }

}

