package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data

public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materia_id;
    private Docente docente_a_cargo;
    private String nom_materia;


    @ManyToMany(mappedBy = "materia")
    @JsonIgnore
    private List<Student> cursantes;


}
