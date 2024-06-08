package org.example;

public class CircleLinkedListTest {
    public static void main(String[] args) {
        CircleLinkedList cll = new CircleLinkedList();

        cll.append(10);
        cll.append(20);
        cll.append(30);
        cll.prepend(40);
        cll.prepend(50);
        cll.prepend(60);
        cll.prepend(70);
        cll.printList();

        cll.deleteFirst();
        cll.deleteFirst();
        cll.deleteFirst();
        cll.deleteFirst();
        cll.printList();

        cll.deleteLast();
        cll.deleteLast();
        cll.deleteLast();
        cll.printList();
    }
}
