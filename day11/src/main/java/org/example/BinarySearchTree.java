package org.example;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
        //null처리 했을때 안했을 때 차이는?
    }

    //add
    public void add(Integer data){
        Node newNode, nowNode;
        newNode = new Node(data);
        nowNode = new Node();
        nowNode = root;
        //있으면 현재 노드와 비교해서 크면 오른쪽, 작으면 왼쪽에 저장
        if (root == null){
            root = newNode;
            nowNode = root;
            return;
        }
        while (nowNode != null){
            if (nowNode.getData() < data){
                if (nowNode.getRight() == null){
                    nowNode.setRight(newNode);
                    return;
                }else {
                    nowNode = nowNode.getRight();
                }
            }else if (nowNode.getData() == data){
                System.out.println("중복된 값");
                return;
            }else {
                if (nowNode.getLeft() == null){
                    nowNode.setLeft(newNode);
                    return;
                }else {
                    nowNode = nowNode.getLeft();
                }
            }
        }
    }


    //remove


    public Node getRoot() {
        return root;
    }
}
