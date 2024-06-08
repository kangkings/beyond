package org.example;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.prepend(10);
        dll.prepend(20);
        dll.prepend(30);

        dll.append(400);
        dll.append(500);
        dll.printList();

        dll.insertAtPosition(3, 9999);
        dll.insertAtPosition(1, 199);
        dll.insertAtPosition(5, 4999);
        dll.printList();
        dll.deleteLast();
        dll.deleteFirst();
        dll.deleteAtPosition(5);
        dll.deleteAtPosition(2);
        dll.deleteAtPosition(1);
        dll.deleteAtPosition(3);
        dll.printList();

        dll.deleteFirst();
        dll.deleteFirst();
        dll.deleteFirst();

        System.out.println(dll.isEmpty());
    }
}
