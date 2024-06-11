package org.example;

import java.util.Map;

public class Trie {
    private TrieNode root;


    public Trie() {
        root = new TrieNode();

    }

    //단어를 입력받아서 반환하는 건 없는 insert기능
    //단어의 길이만큼 반복
    //  만약 현재 노드의 자식노드들 중에서 현재 글자가 포함되어 있으면
    //      현재 노드의 현재 글자에 해당하는 자식노드로 이동한다
    //  그렇지 않으면
    //      새로운노드 생성(현재 글자. 저장가능, 마지막 아님)
    //      현재 노드의 자식노드에 현재 글자를 key로, 새로운 노드를 값으로 추가
    // 현재 노드를 마지막이라고 표시

    public void insert(String word){
        TrieNode nowNode;
        nowNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (nowNode.getChildNodes().containsKey(word.charAt(i))){
                nowNode = nowNode.getChildNodes().get(word.charAt(i));
            }else {
                TrieNode newNode = new TrieNode(word.charAt(i),false);
                nowNode.getChildNodes().put(word.charAt(i), newNode);
            }

        }
    }


    public void printTrie() {
        printTrie(this.root, "", true);
    }

    private void printTrie(TrieNode currentNode, String prefix, boolean isTail) {
        if (currentNode.getData() != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + currentNode.getData() + (currentNode.getLast() ? " (end)" : ""));
        }

        Map<Character, TrieNode> childNodes = currentNode.getChildNodes();
        int size = childNodes.size();
        int i = 0;

        for (Map.Entry<Character, TrieNode> entry : childNodes.entrySet()) {
            i++;
            printTrie(entry.getValue(), prefix + (isTail ? "    " : "│   "), i == size);
        }
    }
}
