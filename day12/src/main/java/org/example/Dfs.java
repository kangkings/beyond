package org.example;

import java.util.List;
import java.util.Stack;

public class Dfs {
    Stack<Integer> stack;
    Boolean[]visited;

    public Dfs(List<List<Integer>>lists) {
        this.stack = new Stack<>();
        this.visited = new Boolean[lists.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    //그래프와 시작 노드 번호를 전달 받아서 반환하는 건 없는 search 기능
    //스택에 시작 노드를 push
    //만약에 스택이 비어있지 않으면 반복
    //  스택에서 노드를 pop
    //  만약에 꺼낸 노드를 방문한 적이 없으면
    //      꺼낸 노드를 출력하고
    //      꺼낸 노드를 방문처리
    //      꺼낸 노드에서 갈 수 있는 노드들 중 방문헌 적이 없는 노드를 스택에 push

    public void search(List<List<Integer>> lists, Integer start) {
        stack.push(start);

        while (!stack.isEmpty()){
            Integer node = stack.pop();
            if (!visited[node]){
                //꺼낸 노드를 출력하고
                System.out.println(node);
                //꺼낸 노드를 방문 처리
                visited[node] = true;
                //꺼낸 노드에서 갈 수 이ㅏㅆ는 노드 중 방문한 적 없는 노드를 스택에 푸시
                for(Integer neighbor : lists.get(node)){
                    if (!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }

    }
}
