package org.example;

public class DoubleNode {
    private DoubleNode next;
    private DoubleNode prev;

    private Integer data;

    public DoubleNode() {
    }

    public DoubleNode(Integer data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
