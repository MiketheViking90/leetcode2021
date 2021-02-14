package algo;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        traverse(traversal, root);
        return traversal;
    }

    private void traverse(List<Integer> traversal, TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(traversal, root.left);
        traversal.add(root.val);
        traverse(traversal, root.right);
    }
}
