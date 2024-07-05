package org.example.spring_day03.test.student;

import org.example.spring_day03.test.model.StudentProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfileImage, Long> {

//    Optional<StudentProfileImage> findByStudent(Student student);
}
