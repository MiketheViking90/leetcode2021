package algo;

import datastructures.DoubleListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, DoubleListNode> map = new HashMap<>();
    private DoubleListNode head;
    private DoubleListNode tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        DoubleListNode node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.size() == capacity) {
            removeNode(tail);
        }

        if (head == null) {
            head = new DoubleListNode(value);
            tail = head;

            head.next = tail;
            head.prev = tail;
            tail.prev = head;
            tail.next = head;

            map.put(key, head);
            return;
        }

        DoubleListNode curNode = map.get(key);
        if (curNode == null) {
            DoubleListNode node = new DoubleListNode(value);
            map.put(key, node);
            addNode(node);
        } else {
            curNode.val = value;
            removeNode(curNode);
            addNode(curNode);
        }
    }

    private void addNode(DoubleListNode node) {
        node.next = head;
        node.prev = tail;

        head.prev = node;
        tail.next = node;
        head = node;
    }

    private void removeNode(DoubleListNode node) {
        DoubleListNode next = node.next;
        DoubleListNode prev = node.prev;

        next.prev = prev;
        prev.next = next;
    }
}

