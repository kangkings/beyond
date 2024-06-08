package org.example;

//단일 연결 리스트
public class LinkedList {

    //마지막에 추가한 노드를 저장하는 tail 변수
    private Node tail;
    private Node head;
    private Integer length;

    public LinkedList() {
        tail = null;
        head = null;
        length = 0;
    }

    // push (tail뒤에 값추가)
    public void push(Integer data){
        Node node = new Node(data);
        // 리스트가 비었을때
        if (this.length == 0){
            head = node;
            tail = node;
            length++;
        } else { //나머지
            tail.setNext(node);
            tail = node;
            length++;
        }

    }
    // delete (tail 삭제)
    public void delete(){
        Node node = new Node();
        node = head;

        //리스트가 비었을 때
        if (length == 0){
            System.out.println("리스트가 비었습니다.");
            return;
        } else if (length == 1) { //노드가 1개일 때
            head = null;
            tail = null;
            length--;
        }else { //나머지
            for (int i = 0; i < this.length; i++) {
                if (i == this.length-2){
                    node.setNext(null);
                    tail = node;
                    length--;
                    return;
                }
                node = node.getNext();
            }
        }
    }

    //deleteAt (원하는 순서의값 삭제)
    public void deleteAt(Integer order){
        Node n = head;
        //현재 길이보다 큰 값일 때
        if(order > length){
            System.out.println("리스트의 길이보다 큽니다.");
            return;
        }else if (order == 1){ //head일 때
            head = head.getNext();
            length--;
        } else if (order == length) {//tail일 때
            for (int i = 0; i < this.length; i++) {
                if (n.getNext() == tail){
                    n.setNext(null);
                    tail = n;
                    length--;
                    return;
                }
                n = n.getNext();
            }
        }else { //나머지
            for (int i = 0; i < order; i++) {
                if (i == order-2){
                    n.setNext(n.getNext().getNext());
                    length--;
                    return;
                }
                n = n.getNext();
            }
        }

    }
    //shift (헤드삭제)
    public void shift(){
        //리스트가 비었을 때
        if (length == 0){
            System.out.println("리스트가 비었습니다.");
            return;
        }else if(length == 1){ //노드가 1개일 때
            head = null;
            tail = null;
            length--;
        }else { //나머지
            head = head.getNext();
            length--;
        }
    }

    //unShift (헤드에 값 추가)
    public void unShift(Integer data){
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        length++;
    }

    //insert (원하는 인덱스에 값 추가)
    public void insert(Integer order, Integer data){
        Node node = new Node(data);
        Node prevNode = head;
        //length+1보다 크거나 1보다 작을때
        if (order > this.length+1 || order < 1){
            System.out.println("추가할 수 없는 위치입니다.");
            return;
        } else if (order == 1) {//head일때
            node.setNext(head);
            head = node;
            length++;
        } else if (order == length+1) {//tail일 때
            tail.setNext(node);
            tail = node;
            length++;
        }else {//나머지
            for (int i = 0; i < order; i++) {
                if (i == order-2){
                    node.setNext(prevNode.getNext());
                    prevNode.setNext(node);
                    length++;
                    return;
                }
                prevNode = prevNode.getNext();
            }
        }

    }
    //isEmpty (비었는지 체크)
    public Boolean isEmpty(){
        return (length==0 ? true : false);
    }

    //printList 출력
    public void printList(){
        Node node = new Node();
        node = head;
        System.out.println("Linked List 전체 출력");
        for (int i = 0; i < this.length; i++) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }


    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
