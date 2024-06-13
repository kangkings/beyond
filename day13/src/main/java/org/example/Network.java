package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Network {
    int cnt;
    public void solution(int n, int[][] arr){
        List<Integer> visited = new ArrayList<>();
        cnt = 0;
        for (int i = 0; i < n; i++) {
            dfs(i, arr, visited);
        }

        System.out.println(cnt);

    }

    public void dfs(int k, int[][] arr, List<Integer> visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        if (!visited.contains(k)){
            while (!stack.isEmpty()){
                int computer = stack.pop();
                visited.add(computer);
                for (int i = k; i < arr[computer].length; i++) {
                    if (arr[computer][i] == 1 && computer != i && !visited.contains(i)){
                        stack.push(i);

                    }
                }

            }
            cnt++;
        }
    }

}
