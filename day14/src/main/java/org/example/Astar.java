package org.example;

import java.net.StandardProtocolFamily;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Astar {

    private Node start;
    private Node goal;
    private List<Node> openList;
    private List<Node> closeList;

    private List<Node> walls;
    private Integer[][] map;

    private final Integer DEFAULT_COST = 10;
    private final Integer DEFAULT_DIAGONAL_COST = 14;


    public Astar(Integer[][] map) {
        this.map = map;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1){
                    start = new Node(j,i);
                } else if (map[i][j] == 2) {
                    goal = new Node(j,i);
                } else if (map[i][j] == 3) {
                    walls.add(new Node(j,i));
                }
            }
        }
    }

    public void findPath(){
        Node nowNode = start;
        //출발지주변 노드를 열린 목록에 추가하기 (기존 리스트에 없다면)
        openList.add(nowNode);
        while (closeList.contains(goal)){

        }
        //nowNode = move(nowNode);

    };

    public void createNearNodes(Node target){
        List<Node> nearNodes = new ArrayList<>();
        nearNodes.add(new Node(target.getX(),target.getY()+1, target));//위
        nearNodes.add(new Node(target.getX(),target.getY()-1, target));//아래
        nearNodes.add(new Node(target.getX()+1,target.getY(), target));//우측
        nearNodes.add(new Node(target.getX()-1,target.getY(), target));//좌측
        nearNodes.add(new Node(target.getX()+1, target.getY()+1, target));//위우측
        nearNodes.add(new Node(target.getX()-1,target.getY()+1, target));//위좌측
        nearNodes.add(new Node(target.getX()+1,target.getY()-1, target));//아래우측
        nearNodes.add(new Node(target.getX()-1,target.getY()-1, target));//아래좌측

        //nearNodes 길이만큼 반복
        //만약 x,y값이 0보다 작은게 있다면
        //  리스트에서 제거
        //아니면
        // 만약 x,y값이 0보다 크고, 열린 목록과 닫힌 목록에서 하나 가져온노드와 x,y값이 다르다면
        //  만약 장애물 목록에서 가져온 노드의 xy값과 다르다면
        //


    }

//    public Node move(Node target){
//        Integer min;
//        openList.remove(target);
//        closeList.add(target);
//
//        //createNearNodes();
//    }

    public Integer calcF(Node node){
        if (node.getParent() == null){
            node.setParent(start);
        }
        return(node.getParent().getX() != node.getX() && node.getParent().getY() != node.getY() ?
                node.getParent().getF()+DEFAULT_COST : node.getParent().getF()+DEFAULT_DIAGONAL_COST);
    }

//    public Integer calcG(Node node){
//        return
//    }

//    public Integer calcH(Node node){
//        return
//    }
}
