package algo;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        traverse(traversal, root);
        return traversal;
    }

    private void traverse(List<Integer> traversal, TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(traversal, root.left);
        traverse(traversal, root.right);
        traversal.add(root.val);
    }
}
