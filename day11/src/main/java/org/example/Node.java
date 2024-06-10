package org.example;

public class Node implements TreePrinter.PrintableNode {
    private Integer data;
    private Node left;
    private Node right;

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Node(Integer data) {
        this.data = data;
        left = null;
        right = null;
    }

    public String getText() {
        return ""+data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
