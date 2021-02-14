package datastructures;

public class MaximumDepthOfNAryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        for (Node neighbor : root.children) {
            depth = Math.max(depth, maxDepth(neighbor));
        }
        return 1+depth;
    }
}
