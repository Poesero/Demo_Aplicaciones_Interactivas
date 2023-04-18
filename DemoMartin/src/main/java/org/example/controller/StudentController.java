package org.example.controller;
import lombok.NonNull;
import org.example.service.ServicioStudent;
import org.example.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private ServicioStudent ss;

    @PostMapping("")
    public ResponseEntity addStudent(@RequestBody final @NonNull Student s) {
        return ss.addStudent(s);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return ss.getAll();
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateStudent(@PathVariable final @NonNull Integer id, @RequestBody final @NonNull Student s) {
        return ss.updateStudent(id, s);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity deleteStudent(@PathVariable final @NonNull Integer id) {
        return ss.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable final @NonNull Integer id) {
        return ss.getStudent(id);
    }
}