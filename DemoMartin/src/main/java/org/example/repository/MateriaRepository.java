package org.example.repository;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.example.models.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia,Integer> {
    @Query(value = "select student_id from estudiante_materia where materia_id = : materiaId",nativeQuery = true)
    List<Integer> findEstudianteByMateriaId(Integer materiaId);

}
