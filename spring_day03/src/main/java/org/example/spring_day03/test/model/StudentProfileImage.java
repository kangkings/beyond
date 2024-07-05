package org.example.spring_day03.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//자주 안쓰이는 쪽에 외래키 지정
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String imageUrl;

//    @OneToOne
//    @JoinColumn(name = "student_idx")//외래키 이름 테이블명_idx
//    private Student student;//참조할 클래스
}
