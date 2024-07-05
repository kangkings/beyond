package org.example.spring_day03.test.student;

import org.example.spring_day03.test.model.Enrollment;
import org.example.spring_day03.test.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByName(String name);

}
