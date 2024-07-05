package org.example.spring_day03.test.student;

import org.example.spring_day03.test.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
//    private final StudentProfileRepository studentProfileRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create() {

//        studentRepository.save(student);
//        StudentProfileImage spi = new StudentProfileImage();
//        spi.setImageUrl("url01");
//        spi.setStudent(student);
//        studentProfileRepository.save(spi);

    }

    public void read() {
//        Student student = studentRepository.findById(1L).get();
//        System.out.println(student.getName());
//        StudentProfileImage spi = studentProfileRepository.findByStudent(student).get();
//        System.out.println(spi.getImageUrl());
    }

    public void update() {
//        Student student = studentRepository.findById(1L).orElseThrow();
//        student.setAge(25);
//        student.setName("kang");
//        studentRepository.save(student);
//        StudentProfileImage spi = new StudentProfileImage();
//        spi.setStudent(student);
//        spi.setIdx(1L);
//        spi.setImageUrl("이걸로 바뀜");
//        studentProfileRepository.save(spi);
    }

    public void delete() {
        Student student = new Student();
        student.setAge(21);
        student.setName("kang");
        studentRepository.delete(student);
    }




}
