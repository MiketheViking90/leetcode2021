package algo;


import datastructures.Node;

import java.util.*;

public class CloneGraph {
    private final Map<Integer, Node> intToNode = new HashMap<>();

    public Node cloneGraph(Node node) {
        return deepCopy(node);
    }

    private Node deepCopy(Node node) {
        if (node == null) {
            return null;
        }
        int val = node.val;
        if (intToNode.containsKey(val)) {
            return intToNode.get(val);
        }

        Node copy = new Node(val);
        intToNode.put(val, copy);

        for (Node n : node.children) {
            copy.children.add(deepCopy(n));
        }
        return copy;
    }


    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();
        Node graph = null;
        Node clone = cg.cloneGraph(graph);
        System.out.println(clone);
    }
}
