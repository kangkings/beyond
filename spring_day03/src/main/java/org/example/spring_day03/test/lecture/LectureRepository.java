package org.example.spring_day03.test.lecture;

import org.example.spring_day03.test.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Lecture findByLectureName(String lectureName);
}
