package algo;

import datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaxLevelSumOfBinaryTree {
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levelToSum = new HashMap<>();
        traverse(levelToSum, root, 1);
        return getMaxLevel(levelToSum);
    }

    private void traverse(Map<Integer, Integer> levelToSum, TreeNode root, int i) {
        if (root == null) {
            return;
        }

        int levelSum = levelToSum.getOrDefault(i, 0);
        levelToSum.put(i, levelSum + root.val);

        traverse(levelToSum, root.left, i+1);
        traverse(levelToSum, root.right, i+1);
    }

    private int getMaxLevel(Map<Integer, Integer> levelToValues) {
        int maxLevel = -1;
        int maxLevelSum = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : levelToValues.entrySet()) {
            int level = entry.getKey();
            int sum = entry.getValue();

            if (sum > maxLevelSum) {
                maxLevelSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
