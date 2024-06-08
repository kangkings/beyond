package org.example;

import java.net.StandardProtocolFamily;

public class DoublyLinkedList<T> {

    private DoubleNode head;
    private DoubleNode tail;
    private Integer length;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    //리스트 끝에 추가
    public void append(Integer data){
        DoubleNode node = new DoubleNode(data);

        if (tail == null){
            head = node;
            tail = node;
            length++;
        }else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            length++;
        }
    }

    //맨앞에 추가
    public void prepend(Integer data){
        DoubleNode node = new DoubleNode(data);
        if (length == 0){
            head = node;
            tail = node;
            length++;
        }else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
            length++;
        }

    }

    //원하는 포지션에 추가
    public void insertAtPosition(Integer position, Integer data){
        DoubleNode node = new DoubleNode(data);
        DoubleNode now = new DoubleNode();
        
        if (position > length+1 || position < 1){
            System.out.println("잘못된 입력");
        } else if (position == 1) {
            prepend(data);
        } else if (position == length){
            append(data);
        }else if (position > length/2){
            now = tail;
            for (int i = 0; i <= length-position; i++) {
                if (i == (length-position)){
                    node.setNext(now);
                    node.setPrev(now.getPrev());
                    now.getPrev().setNext(node);
                    now.setPrev(node);
                    length++;
                    break;
                }
                now = now.getPrev();
            }
        }else {
            now = head;
            for (int i = 0; i < position; i++) {
                if (i == position-2){
                    node.setNext(now.getNext());
                    node.setPrev(now);
                    now.setNext(node);
                    now.getNext().setPrev(node);
                    length++;
                    break;
                }
                now = now.getNext();
            }
        }

    }

    public void deleteFirst(){
        if (length == 0){
            System.out.println("리스트가 비었음");
        }else if (length == 1){
            head = null;
            tail = null;
            length--;
        }else {
            head = head.getNext();
            head.getPrev().setNext(null);
            head.setPrev(null);
            length--;
        }
    }

    public void deleteLast(){
        if (length == 0){
            System.out.println("리스트가 비었음");
        } else if (length == 1) {
            head = null;
            tail = null;
            length --;
        }else {
            tail = tail.getPrev();
            tail.getNext().setPrev(null);
            tail.setNext(null);
            length--;
        }
    }

    //원하는 포지션 삭제
    public void deleteAtPosition(Integer position){
        DoubleNode now = new DoubleNode();
        if (position > length + 1 || position < 1){
            System.out.println("잘못된 입력");
        } else if (position == 1) {
            deleteFirst();
        } else if (position == length) {
            deleteLast();
        } else if (position > length/2) {
            now = tail;
            for (int i = 0; i <= length-position; i++) {
                if (i == length-position){
                    now.getNext().setPrev(now.getPrev());
                    now.getPrev().setNext(now.getNext());
                    now.setNext(null);
                    now.setPrev(null);
                    length--;
                }
                now = now.getPrev();
            }
        }else {
            now = head;
            for (int i = 0; i < position; i++) {
                if (i == position-1){
                    now.getNext().setPrev(now.getPrev());
                    now.getPrev().setNext(now.getNext());
                    now.setNext(null);
                    now.setPrev(null);
                    length--;
                }
                now = now.getNext();
            }
        }

    }

    //비었는지 체크
    public Boolean isEmpty(){
        return (length == 0 ? true : false);
    }

    //출력
    public void printList(){
        DoubleNode node = new DoubleNode();
        node = head;
        System.out.println("리스트 출력");

        for (int i = 0; i < length; i++) {
            if (length == 0){
                System.out.println("빈리스트");
            }else {
                System.out.println(node.getData());

            }
            node = node.getNext();
        }
    }

}
