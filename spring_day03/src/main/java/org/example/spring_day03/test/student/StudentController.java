package org.example.spring_day03.test.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/create")
    public ResponseEntity<String> create(){
        studentService.create();

        return ResponseEntity.ok("생성");
    }
    @GetMapping("/read")
    public ResponseEntity<String> read(){
        studentService.read();

        return ResponseEntity.ok("생성");
    }
    @GetMapping("/update")
    public ResponseEntity<String> update(){
        studentService.update();

        return ResponseEntity.ok("생성");
    }
    @GetMapping("/delete")
    public ResponseEntity<String> delete(){
        studentService.delete();

        return ResponseEntity.ok("생성");
    }


}
