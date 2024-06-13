package org.example;

public class NetworkTest {
    public static void main(String[] args) {
        int[][] arr1 = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] arr2 = {{1,1,0},{1,1,1},{0,1,1}};
        Network nw = new Network();
        nw.solution(3, arr1);
        nw.solution(3, arr2);
    }
}
