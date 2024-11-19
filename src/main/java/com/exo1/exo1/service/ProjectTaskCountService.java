package com.exo1.exo1.service;

import com.exo1.exo1.entity.ProjectTaskCount;
import com.exo1.exo1.repository.ProjectTaskCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskCountService {

    @Autowired
    private ProjectTaskCountRepository repository;

    public Page<ProjectTaskCount> getTaskCounts(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
