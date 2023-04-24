package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Data
@Entity


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dni;
    private String name;
    @NonNull
    @ManyToMany
    @JoinTable(name="estudiante_materia", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name="materia_id"))
    private List<Materia> materia;
}