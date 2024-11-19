package com.exo1.exo1.service;

import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Task;
import com.exo1.exo1.mapper.TaskMapper;
import com.exo1.exo1.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public List<TaskDto> findAll() {
        return taskMapper.toDtos(taskRepository.findAll());
    }

    public TaskDto findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found with id " + id));
        return taskMapper.toDto(task);
    }

    public TaskDto save(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        return taskMapper.toDto(taskRepository.save(task));
    }

    public TaskDto update(Long id, TaskDto taskDto) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found with id " + id));
        taskDto.setId(existingTask.getId());
        return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDto)));
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
