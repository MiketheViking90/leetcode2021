package algo;

import datastructures.TreeNode;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int depth = getDepth(root);
        return getSumAtDepth(root, 0, depth-1);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    private int getSumAtDepth(TreeNode root, int curDepth, int depth) {
        if (root == null) {
            return 0;
        }

        if (curDepth == depth) {
            return root.val;
        }

        return getSumAtDepth(root.left, curDepth+1, depth) +
                getSumAtDepth(root.right, curDepth+1, depth);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.makeTree();
        DeepestLeavesSum dls = new DeepestLeavesSum();
        int sum = dls.deepestLeavesSum(tree);
        System.out.println(sum);
    }
}
