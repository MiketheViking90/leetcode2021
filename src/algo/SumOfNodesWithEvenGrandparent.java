package algo;

import datastructures.TreeNode;

public class SumOfNodesWithEvenGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getSum(root.val, root.left, false) + getSum(root.val, root.right, false);
    }

    private int getSum(int parentVal, TreeNode root, boolean shouldSum) {
        if (root == null) {
            return 0;
        }

        boolean isParentEven = ((parentVal % 2) == 0);
        int sum = shouldSum ? root.val : 0;
        return sum + getSum(root.val, root.left, isParentEven) + getSum(root.val, root.right, isParentEven);
    }
}
