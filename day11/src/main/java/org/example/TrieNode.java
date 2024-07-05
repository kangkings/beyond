package org.example;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Character data;
    private Map<Character, TrieNode> childNodes;
    private Integer last;

    public TrieNode() {
        data = null;
        this.childNodes = new HashMap<>();
        last = 0;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Map<Character, TrieNode> childNodes) {
        this.childNodes = childNodes;
    }




    public TrieNode(Character data) {
        this.data = data;
        this.childNodes = new HashMap<>();
        last = 0;
    }

    public TrieNode(Character data, Integer last) {
        this.data = data;
        this.last = last;
        this.childNodes = new HashMap<>();
    }
}
