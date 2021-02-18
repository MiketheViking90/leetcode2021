package datastructures;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public char c;
    public boolean isTerminal;
    public Map<Character, TrieNode> children;

    public TrieNode() {
        isTerminal = false;
        children = new HashMap<>();
    }

    public TrieNode(char c) {
        this.c = c;
        isTerminal = false;
        children = new HashMap<>();
    }
}
