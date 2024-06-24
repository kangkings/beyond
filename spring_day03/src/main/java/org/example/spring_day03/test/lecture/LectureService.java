package org.example.spring_day03.test.lecture;

import org.example.spring_day03.test.model.Enrollment;
import org.example.spring_day03.test.model.Lecture;
import org.example.spring_day03.test.model.Student;
import org.example.spring_day03.test.student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class LectureService {

    private final LectureRepository repository;
    private final StudentRepository studentRepository;

    private final EnrollmentRepository enrollmentRepository;

    public LectureService(LectureRepository repository, StudentRepository studentRepository, EnrollmentRepository enrollmentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void create() {
        List<String> names = Arrays.asList("DB","리눅스","자바","자료구조","알고리즘","스프링");
        for (String name : names){
            Lecture l = new Lecture();
            l.setLectureName(name);
            repository.save(l);
        }
        enroll();
    }

    public void enroll(){
        List<String> names = Arrays.asList("DB","리눅스","자바","자료구조","알고리즘","스프링");
        Random r = new Random();

        Long student = 0L;


        int num =  r.nextInt(10)+1;

        for (int j = 0; j < names.size(); j++) {
            List<Long> students = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                student = r.nextLong(27)+1;
                if (students.contains(student)){
                    i--;
                }else {
                    students.add(student);
                    Enrollment enrollment = new Enrollment();
                    enrollment.setLecture(repository.findByLectureName(names.get(j)));
                    enrollment.setStudent(studentRepository.findById(student).get());
                    enrollmentRepository.save(enrollment);
                }
            }
            num = r.nextInt(10)+1;

        }
    }

    public void getLectureOfStudent(String name){
        Student student = studentRepository.findByName(name).get();
        System.out.println(student.getName());
        List<Enrollment> enrollments = enrollmentRepository.findAllByStudent(student);
        List<Lecture> lectures = new ArrayList<>();

        System.out.println(student.getName());
        for (Enrollment enrollment : enrollments){
            lectures.add(enrollment.getLecture());
            System.out.println(enrollment.getLecture());
        }
    }

    public void getLectureStatus(){

    }
}
