package datastructures;

import java.util.*;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        Set<Node> visited = new HashSet<>();
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.offer(this);

        while (!toVisit.isEmpty()) {
            int levelSize = toVisit.size();
            while (levelSize-- > 0) {
                Node visit = toVisit.poll();

                for (Node n : visit.neighbors) {
                    toVisit.offer(n);
                }

                sb.append(visit.val);
                sb.append(">");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static Node createGraph() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n1.addNeighbor(n2);
        n1.addNeighbor(n3);
        n1.addNeighbor(n4);
        n1.addNeighbor(n5);

        n2.addNeighbor(n6);

        n3.addNeighbor(n7);
        n3.addNeighbor(n8);

        n8.addNeighbor(n9);

        n9.addNeighbor(n10);

        return n1;
    }
}