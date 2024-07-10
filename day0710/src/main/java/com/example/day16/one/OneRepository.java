package com.example.day16.one;

import com.example.day16.one.model.One;
import com.example.day16.one.model.OneDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OneRepository extends JpaRepository<One, Long> {
    //엔티티와 속성은 대소문자를 구분한다. (One(엔티티), idx(속성))
    //JPQL 키워드는 대소문자를 구분하지 않는다. (Select, FROM, where)
    //테이블 이름이 아닌 엔티티 이름을 사용한다. (One)
    //별칭(o) 사용은 필수적이다.
    //as는 생략이 가능하다.
//    @Query("SELECT o FROM One o")
//    public List<One> findAll();

    // 자바의 변수 값을 사용할 때는 :을 앞에 붙인다.
    @Query("SELECT o FROM One o WHERE o.idx > :oneIdx")
    public List<One> findAllByIdxGreaterThan(Long oneIdx);

    @Query("SELECT o FROM One o JOIN FETCH o.manyList")
    List<One> findAllOneWithMany();


    @Query("SELECT new com.example.day16.one.model.OneDto(o.idx, o.str, m.str) FROM One o JOIN o.manyList m")
    List<OneDto> findAllOneDto();


    Page<One> findPageBy(Pageable pageable);

    Slice<One> findSliceBy(Pageable pageable);


    @EntityGraph(attributePaths = {"manyList"}) // 스프링 데이터 JPA 에서 FETCH 조인을 편하게 하기 위한 설정, 현재 조회하는 엔티티에 있는 연관된 컬렉션을 명시적으로 FETCH 조인하도록 지정한 것
    List<One> findAllEntityGraphBy();

}
