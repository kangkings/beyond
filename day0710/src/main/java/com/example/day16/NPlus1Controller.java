package com.example.day16;

import com.example.day16.many.Many;
import com.example.day16.many.ManyService;
import com.example.day16.one.OneService;
import com.example.day16.one.model.One;
import com.example.day16.one.model.OneDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nplus1")
public class NPlus1Controller {
    private final ManyService manyService;
    private final OneService oneService;

    public NPlus1Controller(ManyService manyService, OneService oneService) {
        this.manyService = manyService;
        this.oneService = oneService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public void create() {
        List<Many> manyList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Many many = new Many();
            many.setStr("many" + i);
            manyList.add(many);
        }
        manyService.saveAll(manyList);
        List<One> oneList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            One one = new One();
            one.setStr("one" + i);
            one.setManyList(manyList);
            oneList.add(one);
        }
        oneService.saveAll(oneList);
        System.out.println("-------------------------------");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public void read() {

        List<One> result = oneService.findAll();

        for (One one : result) {
            for (Many many : one.getManyList()) {
                System.out.println(many.getStr());
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jpql01")
    public void jpql01() {

        List<One> result = oneService.jpql01();

        for (One one : result) {
            for (Many many : one.getManyList()) {
                System.out.println(many.getStr());
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jpql02")
    public void jpql02() {

        List<One> result = oneService.jpql02();

        for (One one : result) {
            for (Many many : one.getManyList()) {
                System.out.println(many.getStr());
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jpql03")
    public void jpql03() {

        List<One> result = oneService.jpql03();

//        for (One one : result) {
//            for (Many many : one.getManyList()) {
//                System.out.println(many.getStr());
//            }
//        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/jpql04")
    public void jpql04() {

        List<OneDto> result = oneService.jpql04();

        for (OneDto oneDto : result) {
            System.out.println(oneDto.getManyStr());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jpql05")
    public void jpql05(Integer page, Integer size) {

        List<One> result = oneService.jpql05(page, size);

        for (One one : result) {
            for (Many many : one.getManyList()) {
                System.out.println(many.getStr());
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/jpql06")
    public void jpql06(Integer page, Integer size) {

        List<One> result = oneService.jpql06(page, size);

        for (One one : result) {
            for (Many many : one.getManyList()) {
                System.out.println(many.getStr());
            }
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/jpql07")
    public void jpql07() {

        List<One> result = oneService.jpql07();

        for (One one : result) {
            for (Many many : one.getManyList()) {
                System.out.println(many.getStr());
            }
        }
    }

}
