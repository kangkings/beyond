package org.example.spring_day03.test.lecture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService service;

    public LectureController(LectureService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public ResponseEntity<String> create(
    ){
        service.create();
        return ResponseEntity.ok("강의 생성");
    }

    @GetMapping("/showLectures")
    public ResponseEntity<String> showLectures(
             String student
    ){
        service.getLectureOfStudent(student);
        return ResponseEntity.ok("학생이 수강중인 강의목록 출력");
    }
}
