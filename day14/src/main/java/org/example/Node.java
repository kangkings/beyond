package org.example;

public class Node {
    private Integer x;
    private Integer y;
    private Integer f;
    private Integer h;
    private Integer g;

    private Node parent;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node() {
        parent = null;
    }

    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        parent = null;
    }

    public Node(Integer x, Integer y, Node parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public Node(Integer x, Integer y, Integer f, Integer h, Integer g, Node parent) {
        this.x = x;
        this.y = y;
        this.f = f;
        this.h = h;
        this.g = g;
        this.parent = parent;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }
}
