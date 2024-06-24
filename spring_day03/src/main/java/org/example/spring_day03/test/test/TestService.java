package org.example.spring_day03.test.test;

import org.example.spring_day03.test.model.Test;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void create() {
        Test test = new Test();
        test.setStr("test01");
        testRepository.save(test);
    }

    public void read() {
        Test test = testRepository.findById(1L).get();
        System.out.println(test.getIdx());
    }

    public void update() {
        Test test = new Test();
        test.setIdx(1L);
        test.setStr("test02");
        testRepository.save(test);
    }

    public void delete() {
        Test test = new Test();
        test.setIdx(1L);
        test.setStr("test02");
        testRepository.delete(test);
    }

    public void readByIdx() {
        Test t1 = new Test();
        t1.setIdx(1L);
        t1.setStr("test01");
        Optional<Test> test = testRepository.findByIdxAndStr(t1.getIdx(),t1.getStr());

    }
}
