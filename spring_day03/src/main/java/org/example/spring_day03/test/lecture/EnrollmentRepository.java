package org.example.spring_day03.test.lecture;

import org.example.spring_day03.test.model.Enrollment;
import org.example.spring_day03.test.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    Enrollment findByStudent(Student student);

    List<Enrollment> findAllByStudent(Student student);
}
