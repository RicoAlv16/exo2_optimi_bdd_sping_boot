package com.exo1.exo1.controller;

import com.exo1.exo1.entity.ProjectTaskCount;
import com.exo1.exo1.service.ProjectTaskCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project-task-counts")
public class ProjectTaskCountController {

    @Autowired
    private ProjectTaskCountService service;

    @GetMapping
    public Page<ProjectTaskCount> getProjectTaskCounts(Pageable pageable) {
        return service.getTaskCounts(pageable);
    }
}
