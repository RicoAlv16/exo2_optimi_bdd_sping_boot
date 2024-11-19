package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.entity.Projet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TaskMapper.class})  // Utilisation de TaskMapper pour convertir les tasks
public interface ProjetMapper {
    ProjetDto toDto(Projet projet);   // Convertir Projet en ProjetDto
    Projet toEntity(ProjetDto projetDto);  // Convertir ProjetDto en Projet
    List<ProjetDto> toDtos(List<Projet> projets);  // Convertir liste de Projet en liste de ProjetDto
    List<Projet> toEntities(List<ProjetDto> projetDtos);  // Convertir liste de ProjetDto en liste de Projet
}
