package com.exo1.exo1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProjectTaskCount {

    @Id
    private Long projetId;

    private String projetName;

    private Long taskCount;

    // Getters et Setters
    public Long getProjetId() {
        return projetId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }

    public String getProjetName() {
        return projetName;
    }

    public void setProjetName(String projetName) {
        this.projetName = projetName;
    }

    public Long getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Long taskCount) {
        this.taskCount = taskCount;
    }
}
