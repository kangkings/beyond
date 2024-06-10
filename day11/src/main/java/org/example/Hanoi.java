package org.example;

public class Hanoi {
    //하노이 타워
    //기둥 번호는 1 ~ 3번
    //원반번호는 가장 작은원반부터 1,2,3
    // 이동(원반 번호 / from / to)를 전달받는다
        // 원반 번호가 1보다 크면 원반번호-1을 from에서 from과 to가 아닌 곳으로 이동
        // 원반 번호를 from에서 to로 옮겼다고 출력
        // 원반 번호가 1보다 크면 원반 번호 -1을 from과 to가 아닌 곳에서 to로 이동
    public void move(Integer ring, Integer from, Integer to){
        if (ring > 1){
            move(ring-1, from, 6-from-to);
        }
        System.out.printf("%d에서 %d로 옮김\n", from,to);
        if (ring > 1){
            move(ring-1, 6-from-to, to);
        }
    }
}
