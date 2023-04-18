package org.example.controller;

import lombok.NonNull;
import org.example.models.Materia;
import org.example.models.StudentDTO;
import org.example.service.ServicioMateria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
@CrossOrigin(origins = "*")
public class MateriaController {

    @Autowired
    private ServicioMateria sm;

    @PostMapping("")
    public ResponseEntity addMateria(@RequestBody final @NonNull Materia m) { return sm.addMateria(m); }

    @GetMapping("/{id}/cursantes")
    public List<StudentDTO> findStudentsByMateriaId(@PathVariable Integer id){
        return sm.findEstudianteByMateriaId(id);
    }

}
