package org.example.service;

import org.example.models.Materia;
import org.example.models.Student;
import org.example.models.StudentDTO;
import org.example.repository.MateriaRepository;
import org.example.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

public class ServicioMateria {

    private final MateriaRepository mr;
    private final StudentRepository sr;

    private final ModelMapper mm = new ModelMapper();
    @Autowired
    public ServicioMateria(MateriaRepository mr, StudentRepository sr) { this.mr = mr;
    this.sr = sr;}

    public ResponseEntity addMateria(Materia m) {
        mr.save(m);
        return ResponseEntity.status(CREATED).build();
    }

    public List<StudentDTO> findEstudianteByMateriaId(Integer id)
    {
        List<Integer> studentIdList = mr.findEstudianteByMateriaId(id);
        List<StudentDTO> cursantes = new ArrayList<>();
        for (Integer studentId : studentIdList){
            Student s = sr.findById(studentId).orElseThrow();
            cursantes.add(mm.map(s, StudentDTO.class));

        }
    return cursantes;
    }

}
