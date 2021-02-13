package algo;

import datastructures.TreeNode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        return 1 + Math.max(lDepth, rDepth);
    }
}
