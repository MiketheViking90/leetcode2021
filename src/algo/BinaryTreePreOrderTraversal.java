package algo;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        traverse(traversal, root);
        return traversal;
    }

    private void traverse(List<Integer> traversal, TreeNode root) {
        if (root == null) {
            return;
        }

        traversal.add(root.val);
        traverse(traversal, root.left);
        traverse(traversal, root.right);
    }
}
