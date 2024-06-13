package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
    Queue<Integer> queue;
    Boolean[] visited;

    public Bfs(List<List<Integer>> lists) {
        queue = new LinkedList<>();
        visited = new Boolean[lists.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }


    public void search(List<List<Integer>> lists, Integer start){
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            Integer node =  queue.poll();
            List<Integer> neighbors = lists.get(node);
            for (Integer neighbor : neighbors){
                if (!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
