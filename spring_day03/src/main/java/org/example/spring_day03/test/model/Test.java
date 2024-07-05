package org.example.spring_day03.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "test")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
    //무조건 기본키가 될 속성이 있어야 한다.
    //없을시 에러발생
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    //테이블 컬럼속성은 @column어노테이션 옵션으로 달아준다.
    //직접 지정하고 싶으면 어노테이션 속성에 아래의 옵션 추가
    // columnDefinition = "varchar(100) not null default ''"처럼 쓸 수 있다.
    @Column(nullable = false, unique = true)
    private String str;

}
