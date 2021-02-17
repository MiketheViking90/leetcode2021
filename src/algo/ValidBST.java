package algo;

import datastructures.TreeNode;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (!(val < maxVal && val > minVal)) {
            return false;
        }
        return checkBST(root.left, minVal, val) && checkBST(root.right, val, maxVal);
    }
}
