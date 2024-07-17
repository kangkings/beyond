package com.example.day16.one;

import com.example.day16.one.model.One;
import com.example.day16.one.model.OneDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OneService {
    private final OneRepository oneRepository;


    public void saveAll(List<One> oneList) {
        oneRepository.saveAll(oneList);
    }

    public List<One> findAll() {

        return oneRepository.findAll();
    }

    public List<One> jpql01() {

        return oneRepository.findAll();
    }

    public List<One> jpql02() {

        return oneRepository.findAllByIdxGreaterThan(1L);
    }

    public List<One> jpql03() {
        //return oneRepository.findAll();
        return oneRepository.findAllOneWithMany();
    }


    public List<OneDto> jpql04() {
        List<OneDto> result = oneRepository.findAllOneDto();

        return result;
    }


    public List<One> jpql05(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "idx"));
        Page<One> result = oneRepository.findPageBy(pageable);

        List<One> oneList = result.getContent();
        System.out.println("total : " + result.getTotalElements()); // 전체 수를 카운트 하는 건 안좋음
        System.out.println("num : " + result.getNumber());
        System.out.println("totalPage : " + result.getTotalPages());
        System.out.println("first : " + result.isFirst());
        System.out.println("next : " + result.hasNext());
        System.out.println("last : " + result.isLast());

        return oneList;
    }

    public List<One> jpql06(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "idx"));
        Slice<One> result = oneRepository.findSliceBy(pageable);

        List<One> oneList = result.getContent();
//        System.out.println("total : " + result.getTotalElements());
        System.out.println("num : " + result.getNumber());
//        System.out.println("totalPage : " + result.getTotalPages());
        System.out.println("first : " + result.isFirst());
        System.out.println("next : " + result.hasNext());
        System.out.println("last : " + result.isLast());

        return oneList;
    }


    public List<One> jpql07() {
        List<One> result = oneRepository.findAllEntityGraphBy();


        return result;
    }



}
