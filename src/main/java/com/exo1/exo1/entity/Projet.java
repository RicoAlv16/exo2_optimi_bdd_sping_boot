package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "projet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projet_id")
    private Long id;

    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_projet", joinColumns = @JoinColumn(name = "projet_id"), inverseJoinColumns = @JoinColumn(name = "users_id"))
    @BatchSize(size = 10) // Optimisation de la récupération en lot
    private Set<User> users;

    @OneToMany(mappedBy = "projet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @BatchSize(size = 10) // Optimisation de la récupération en lot
    private Set<Task> tasks;


}
