package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] graph1 = {{0,3,5},{0,4,5},{0,2,6},{1,2,3},{1,5,3},{1,6,8},{2,4,4},{2,6,5},{3,5,8},{3,7,4},{5,6,2},{5,7,5}};
        int[][] graph5 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int[][] graph6 = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        Dijsktra dijsktra = new Dijsktra();
        dijsktra.findPath(6, graph6, 4,6,2);
        dijsktra.printPath();

        int[][] graph2 = {{0, 1, 6}, {0, 2, 3}, {0, 3, 9}, {0, 4, 8}, {1, 2, 2}, {2, 3, 5}, {2, 4, 7}, {3, 2, 4}, {4, 2, 13}};
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.findPath(graph2,0,6);

        int[][] graph3 = {{0,4,1}, {1,0,3},{1,6,1},{2,1,1},{3,7,7},{4,2,2},{6,2,4},{6,4,4},{6,5,9}};
        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.findPath(8, graph3);
        floydWarshall.printPath();

    }
}