package org.example;

import java.util.*;

public class Dijsktra {
    final int INF = Integer.MAX_VALUE;
    boolean[] visited;
    int[] costs;
    int[] path;

    int cnt;

    public int[] findPath(int nodeNum, int[][] graph, int s,int a, int b) {
        cnt = 0;
        visited = new boolean[nodeNum];
        costs = new int[nodeNum];
        path = new int[nodeNum];

        Arrays.fill(costs, INF);
        Arrays.fill(path, 0);

        int startNode = s-1;
        costs[startNode] = 0;

        for (int i = 0; i < nodeNum - 1; i++) {
            int minNode = findMinNode(costs, visited);
            visited[minNode] = true;

            for (int[] edge : graph) {
                int from;
                int to;
                int cost;
                from = 0;
                to = 0;
                cost = 0;

                if (minNode == edge[0]-1) {
                    from = edge[0]-1;
                    to = edge[1]-1;
                    cost = edge[2];
                } else if (minNode == edge[1]-1) {
                    from = edge[1]-1;
                    to = edge[0]-1;
                    cost = edge[2];
                }

                if (!visited[to] && from == minNode && costs[from] + cost < costs[to]) {
                    costs[to] = costs[from] + cost;
                    path[to] = from;
                }
            }
        }

//        for (int i = 0; i < costs.length; i++) {
//            if (costs[i] <= k){
//                cnt++;
//            }
//        }
//        System.out.printf("%d개 있음",cnt);
        return costs;
    }

    private int findMinNode(int[] costs, boolean[] visited) {
        int minCost = INF;
        int minNode = -1;

        for (int i = 0; i < costs.length; i++) {
            if (!visited[i] && costs[i] < minCost) {
                minCost = costs[i];
                minNode = i;
            }
        }

        return minNode;
    }


    public void printPath() {

        System.out.println("costs:");
        for (int i = 0; i < costs.length; i++) {
            System.out.println("To node " + i + ": " + costs[i]);
        }

        System.out.println("path:");
        for (int i = 0; i < path.length; i++) {
            System.out.println("To node " + i + ": " + path[i]);
        }

        for (int i = 1; i < path.length; i++) {
            System.out.print(i + " : ");
            int current = i;
            while (path[current] != 0) {
                current = path[current];
                System.out.print(current + " ");
            }
            System.out.println(0);

        }
    }

}
