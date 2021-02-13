package algo;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new TreeMap<>();
        traverse(levels, root, 0);
        return new ArrayList<>(levels.values());
    }

    private void traverse(Map<Integer, List<Integer>> levels, TreeNode root, int i) {
        if (root == null) {
            return;
        }

        List<Integer> level = levels.getOrDefault(i, new ArrayList<>());
        level.add(root.val);
        levels.put(i, level);
        traverse(levels, root.left, i+1);
        traverse(levels, root.right, i+1);
    }
}
