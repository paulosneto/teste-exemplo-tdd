package com.tdd.test.usecase.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    // atribuindo colunas para a tabela "course"
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private int workload;

}

