package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers {
    public Integer solution(int[] numbers, int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int node = queue.poll();
                queue.add(node+numbers[i]);
                queue.add(node+numbers[i]*(-1));
            }
        }
        while (!queue.isEmpty()){
            if (queue.poll() == target){
                cnt++;
            }
        }
        return cnt;

    }


}
