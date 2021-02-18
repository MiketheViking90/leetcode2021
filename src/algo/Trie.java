package algo;

import datastructures.TrieNode;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node = node.children.get(c);
        }
        node.isTerminal = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isTerminal;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("apple");
//        boolean b = trie.search("apple");
//        System.out.println(b);
//
//        b = trie.search("app");
//        System.out.println(b);
//
//        b = trie.startsWith("app");
//        System.out.println(b);
//
//        trie.insert("app");
//
//        b = trie.search("app");
//        System.out.println(b);

        trie.insert("a");
        boolean b = trie.search("a");
        System.out.println(b);

        b = trie.startsWith("a");
        System.out.println(b);
    }
}
