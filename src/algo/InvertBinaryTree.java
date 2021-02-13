package algo;

import datastructures.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        return root;
    }
}
