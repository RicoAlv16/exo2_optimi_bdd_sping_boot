package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")  // Mapper pour Task
public interface TaskMapper {
    TaskDto toDto(Task task);   // Convertir Task en TaskDto
    Task toEntity(TaskDto taskDto);  // Convertir TaskDto en Task
    List<TaskDto> toDtos(List<Task> tasks);  // Convertir liste de Task en liste de TaskDto
    List<Task> toEntities(List<TaskDto> taskDtos);  // Convertir liste de TaskDto en liste de Task
}
