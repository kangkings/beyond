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
//      3) 삭제
//            (1) 자식 노드가 없는 노드 삭제
//    그냥 삭제
//
//            (2) 자식이 하나인 노드 삭제
//    삭제하는 노드 대신에 자식 노드로 대체
//
//            (3) 자식이 두개인 노드 삭제
//    왼쪽을 기준으로 했을 때
//    삭제하는 노드 대신에 왼쪽 서브트리에서 가장 큰 노드로 대체
//
//    오른쪽을 기준으로 했을 때
//    삭제하는 노드 대신에 오른쪽 서브트리에서 가장 작은 노드로 대체

    public void remove(Integer data){
        if (root == null){
            System.out.println("빈트리");
        }else {
            removeRecur(data, root);
        }
    }
    public Node removeRecur(Integer data, Node node){
        if (node.getData() == data){
            if (node.getRight() == null && node.getLeft() == null){
                node = null;
            } else if (node.getRight() == null && node.getLeft() != null) {
                node = node.getLeft();
            } else if (node.getRight() != null && node.getLeft() == null) {
                node = node.getRight();
            }else {
                //왼쪽기준
                Node lastNode;
                lastNode = node.getLeft();
                if (lastNode.getRight() == null){
                    node = lastNode;
                }else {
                    while (lastNode != null){
                        if (lastNode.getRight().getRight() == null){
                            if (lastNode.getRight().getLeft() != null){
                                Node tmp;
                                tmp =  lastNode.getRight();
                                lastNode.getRight().setRight(node.getRight());
                                lastNode.setRight(lastNode.getRight().getLeft());
                                tmp.setLeft(node.getLeft());
                                node = tmp;
                                return node;
                            }else {
                                lastNode.getRight().setRight(node.getRight());
                                lastNode.getRight().setLeft(node.getLeft());

                                node = lastNode.getRight();
                                lastNode.setRight(null);
                                return node;
                            }

                        }
                        lastNode = lastNode.getRight();
                    }
                }
            }
        }else {
            if (node.getData() < data){
                node = removeRecur(data, node.getRight());

            }else {
                node = removeRecur(data, node.getLeft());
            }
        }
        return node;
    }



    public Node getRoot() {
        return root;
    }


}
