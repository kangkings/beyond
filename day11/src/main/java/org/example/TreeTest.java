package org.example;

public class TreeTest {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(12);
        bst.add(8);
        bst.add(2);
        bst.add(20);
        bst.add(23);
        bst.add(14);

        TreePrinter.print(bst.getRoot());

    }
}
