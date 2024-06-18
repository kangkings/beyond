package org.example;

import java.util.Stack;


public class BellmanFord {
    static final Integer INF = Integer.MAX_VALUE;

    Integer[][] distance;

    public boolean findPath(int[][] graph, int start, int n) {
        //각 노드까지의 최단거리 배열 초기화
        distance = new Integer[n][2];  //{{부모, 거리}, ...}
        for (int i = 0; i < n; i++) {
            if (i == start) {
                distance[i][0] = start;
                distance[i][1] = 0;
            } else {
                distance[i][0] = null;
                distance[i][1] = INF;
            }
        }

        int curr, next, cost;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.length; j++) {
                curr = graph[j][0];
                next = graph[j][1];
                cost = graph[j][2];
                if (distance[curr][1] != INF) {
                    if (distance[curr][1] + cost < distance[next][1]) {
                        if (i == n - 1) {
                            System.out.println("순환 발생");
                            return false;
                        }
                        distance[next][1] = distance[curr][1] + cost;
                        distance[next][0] = curr;
                    }
                }
            }
            printDistance(i);
        }
        System.out.println();
        printPath(start);
        return true;
    }

    public void printDistance(int k){
        System.out.print(k+"번째 순회: ");
        for (int i = 0; i < distance.length; i++) {
            if (distance[i][1] != INF) {
                System.out.printf("%d ", distance[i][1]);
            } else {
                System.out.printf("%s ", "INF");
            }
        }
        System.out.println();
    }

    public void printPath(Integer start) {
        Integer nowParent = null;

        for (int i = distance.length - 1; i >= 0; i--) {
            if (distance[i][1] != INF) {
                nowParent = distance[i][0];
                Stack<Integer> stack = new Stack<>();
                for (int j = 0; j < distance.length; j++) {
                    if (nowParent == start.intValue()) {
                        stack.push(distance[nowParent][0]);
                        break;
                    } else {
                        stack.push(nowParent);
                    }
                    nowParent = distance[nowParent][0];
                }
                System.out.printf("출발지 %d번 Vertex부터 %d번 Vertex까지의 최단경로: ", start, i);
                for (int j = 0; j < distance.length; j++) {
                    if (stack.isEmpty()) {
                        break;
                    }
                    System.out.printf("%d -> ", stack.pop());
                }
                System.out.printf("%d\n", i);
            }

        }
        System.out.println();
    }


}
