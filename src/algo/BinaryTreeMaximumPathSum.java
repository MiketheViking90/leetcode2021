package algo;

import datastructures.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lSum = maxPathSum(root.left);
        int rSum = maxPathSum(root.right);
        return root.val + Math.max(lSum, rSum);
    }
}
