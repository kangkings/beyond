package org.example;

public class Node {
    private Integer data;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
        left = null;
        right = null;
    }
}
