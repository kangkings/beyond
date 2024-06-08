package org.example;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.push(10);
        ll.push(20);
        ll.push(30);
        ll.push(40);
        ll.push(50);

        ll.printList();

        ll.shift();

        ll.printList();

        ll.deleteAt(4);
        ll.printList();

        ll.unShift(99);
        ll.unShift(98);
        ll.unShift(97);
        ll.unShift(96);
        ll.unShift(95);

        ll.printList();

        ll.insert(9,1110);
        ll.printList();
    }
}
