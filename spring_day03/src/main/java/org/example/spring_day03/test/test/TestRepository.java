package org.example.spring_day03.test.test;

import org.example.spring_day03.test.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    //정의된 키워드들을 조합하면 이를 기반으로 SQL을 커스텀해서 만들어준다.
    Optional<Test> findByIdxAndStr(Long idx, String str);

}
