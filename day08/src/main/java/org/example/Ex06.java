package org.example;

import java.util.*;

public class Ex06 {
    public static void main(String[] args) {
        List<Human> team4 = new ArrayList<>();
        Snack s1 = new Snack("감자깡",2000,"감자맛");
        Snack s2 = new Snack("고구마깡",2000,"고구마맛");
        Snack s3 = new Snack("새우깡",2000,"새우맛");
        Snack s4 = new Snack("눈을감자",2000,"감자맛");
        Snack s5 = new Snack("포스틱",2000,"감자맛");
        Snack s6 = new Snack("맛동산",2000,"맛동산맛");
        Snack s7 = new Snack("꿀꽈배기",2000,"꿀맛");

        team4.add(new Human("김우혁",28));
        team4.add(new Human("도지민",28));
        team4.add(new Human("서재은",28));


        team4.get(0).snack.add(s1);
        team4.get(0).snack.add(s3);
        team4.get(0).snack.add(s2);
        team4.get(1).snack.add(s1);
        team4.get(1).snack.add(s6);
        team4.get(1).snack.add(s5);
        team4.get(2).snack.add(s4);
        team4.get(2).snack.add(s7);

        System.out.println(team4.get(0).toString());
        System.out.println(team4.get(0).snack.toString());
        List<String> a = new Vector<>();
        


    }
}
