package org.example.spring_day03.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String teamName;

    //팀이 1, 학생이 N인 1:N관계
    //양방향, 단방향에 따라 달라짐
    //양방향을 가정하면 1측에 OneToMany, N측에 ManyToOne
    //리스트의 경우 객체가 만들어져 있어야 담길 수 있기 때문에 구현한 객체 생성해둬야 함
    //해당 이름의 외래키를 참조하여 값 찾기
    @OneToMany(mappedBy = "team")
    private List<Student> students = new ArrayList<>();


}
