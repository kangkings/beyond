package org.example;

import java.net.StandardProtocolFamily;
import java.sql.PreparedStatement;

public class CircleLinkedList {
    private Integer length;
    private Node head;
    private Node tail;

    public CircleLinkedList() {
        this.length = 0;
        head = null;
        tail = null;
    }

    public void append(Integer data){
        Node node = new Node(data);
        if (length==0){
            head = node;
            tail = node;
            node.setNext(node);
            length++;
        }else {
            tail.setNext(node);
            node.setNext(head);
            tail = node;
            length++;
        }
    }

    public void prepend(Integer data){
        Node node = new Node(data);
        if (length == 0){
            append(data);
        }else {
            node.setNext(head);
            head = node;
            tail.setNext(node);
            length++;
        }
    }

    public void deleteFirst(){
        if (length == 0){
            System.out.println("빈 리스트");
        } else if (length == 1) {
            head = null;
            tail = null;
            length--;
        }else {
            head = head.getNext();
            tail.getNext().setNext(null);
            tail.setNext(head);
            length--;
        }
    }

    public void deleteLast(){
        Node now = new Node();
        now = head;
        if (length == 0 || length == 1){
            deleteFirst();
        }else {
            for (int i = 0; i < length; i++) {
                if (now.getNext() == tail){
                    now.setNext(head);
                    tail.setNext(null);
                    tail = now;
                    length--;
                    break;
                }
                now = now.getNext();
            }
        }
    }

    public void insertAtPosition(Integer position,Integer data){
        Node node = new Node(data);
        Node now = new Node();
        if (position < 1 || position > length+1){
            System.out.println("잘못된 위치");
        } else if (position == 1) {
            prepend(data);
        } else if(position == length){
            append(data);
        } else {
            now = head;
            for (int i = 0; i < position; i++) {
                if (i == position-2){
                    node.setNext(now.getNext());
                    now.setNext(node);
                    length++;
                }
                now = now.getNext();
            }

        }
    }
    
    public void deleteAtPosition(Integer position, Integer data){
        Node now = new Node();
        if (position < 1 || position > length +1){
            System.out.println("잘못된 위치");
        } else if (position == 1) {
            deleteFirst();
        } else if (position == length) {
            deleteLast();
        }else {
            now = head;
            for (int i = 0; i < position; i++) {
                if (i == position-2){

                }
            }
        }

    }
    
    public Boolean isEmpty(){
        return (length == 0 ? true : false);
    }
    
    public void printList(){
        Node now = new Node();
        now = head;
        System.out.println("리스트 출력");
        if (length == 0){
            System.out.println("빈 리스트");
        }
        for (int i = 0; i < length; i++) {

            System.out.println(now.getData());

        now = now.getNext();
        }
    }
}
