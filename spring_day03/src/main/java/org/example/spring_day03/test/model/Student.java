package org.example.spring_day03.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private Integer age;

    //mappedBy는 주인설정
//    @OneToOne(mappedBy = "student")
//    private StudentProfileImage studentProfileImage;

    //외래키는 다측에서 관리
    @ManyToOne
    @JoinColumn(name = "team_idx")
    private Team team;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
    public Student(Long idx, String name, Integer age) {
        this.idx = idx;
        this.name = name;
        this.age = age;
    }

    public Student(String name, Integer age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }
}
