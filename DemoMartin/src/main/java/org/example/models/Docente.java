package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data

public class Docente {

    private ArrayList<Materia> materias;

}
