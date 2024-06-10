package org.example;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Character data;
    private Map<Character, TrieNode> childNodes;
    private Boolean isLast;

    public TrieNode() {
        data = null;
        this.childNodes = new HashMap<>();
        isLast = false;
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

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public TrieNode(Character data) {
        this.data = data;
        this.childNodes = new HashMap<>();
        isLast = false;
    }

    public TrieNode(Character data, Boolean isLast) {
        this.data = data;
        this.isLast = isLast;
        this.childNodes = new HashMap<>();
    }
}
