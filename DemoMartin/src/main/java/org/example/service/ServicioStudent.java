package org.example.service;

import org.example.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.example.repository.StudentRepository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Service
public class ServicioStudent {

    private final StudentRepository sr;

    @Autowired
    public ServicioStudent(StudentRepository sr){
        this.sr = sr;
    }

    public ResponseEntity addStudent(Student m) {
        sr.save(m);
        return ResponseEntity.status(CREATED).build();
    }
    public List<Student> getAll() {
        return sr.findAll();
    }
    public ResponseEntity updateStudent(Integer id, Student mo) {
        Student st = sr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "estudiante no encontrado"));
        st.setDni(mo.getDni());
        st.setName(mo.getName());
        sr.save(st);
        return ResponseEntity.status(OK).build();
    }
    public ResponseEntity deleteStudent(Integer id) {
        sr.deleteById(id);

        return ResponseEntity.status(OK).build();
    }
    public Student getStudent(Integer id) {
        return sr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "estudiante no encontrado"));

    }
}
