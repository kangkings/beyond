package org.example;

public class Bst {
    Node root;

    public Bst() {
        this.root = null;
    }

    // 숫자 하나를 전달받고 반환하는 건 없는 이름이 add인 메소드
    public void add(Integer data) {
        //      만약에 root가 비어있으면
        //          노드 객체를 생성해서 데이터를 저장
        //      그렇지않으면
        //          현재 노드가 비어있지 않으면 반복
        //              만약에 데이터가 현재 노드의 데이터보다 작으면
        //                  현재 노드의 왼쪽 노드가 비어 있으면
        //                      노드 객체를 생성해서 데이터를 저장
        //                      현재 노드의 왼쪽 노드에 생성한 노드를 저장
        //                  그렇지 않으면
        //                      현재 노드를 왼쪽의 노드로 변경
        //              그렇지 않고 만약에 데이터가 현재 노드의 데이터보다 크면
        //                  현재 노드의 오른쪽 노드가 비어 있으면
        //                      노드 객체를 생성해서 데이터를 저장
        //                      현재 노드의 오른쪽 노드에 생성한 노드를 저장
        //                  그렇지 않으면
        //                      현재 노드를 오른쪽의 노드로 변경
    }

    public void add2(Integer data) {
        // 만약에 root가 null이면
        if (this.root == null) {
            //      객체 생성해서 데이터 저장
            Node newNode;
            newNode = new Node(data);
            //      root에 생성한 객체 저장
            this.root = newNode;
        }
        //  그렇지 않으면
        else {
            this.addRecur(this.root, data);
        }


    }

    // 특정 노드에 어떤 데이터를 추가할건지를 입력받아서 노드를 반환하는 기능
    public Node addRecur(Node node, Integer data) {
    //      만약에 특정 노드가 비어있으면
        if(node == null) {
    //          노드 객체를 생성해서 데이터를 저장
            Node newNode;
            newNode = new Node(data);
    //          생성한 노드 반환
            return newNode;
        }

    //      만약에 데이터가 특정 노드의 데이터보다 크면
        if(data > node.getData()) {
    //          특정 노드의 오른쪽에 특정 노드의 오른쪽 노드에 데이터를 추가해서 반환 받은 노드를 저장
            node.setRight(addRecur((Node)node.getRight(), data));
        }
    //      그렇지 않고 만약에 데이터가 특정 노드의 데이터보다 작으면
        else if(data < node.getData()) {
    //          특정 노드의 왼쪽에 특정 노드의 왼쪽에 노드에 데이터를 추가해서 반환 받은 노드를 저장
            node.setLeft(addRecur((Node)node.getLeft(), data));
        }

        // 특정 노드 반환
        return node;
    }

    // 삭제
    //  1. 자식이 없을 때     바로 삭제
    //  2. 자식이 하나일 때   자식이 부모로 대체
    //  3. 자식이 2개일 때    왼쪽의 서브트리에서 제일 큰 노드가 삭제되는 노드를 대체

}
