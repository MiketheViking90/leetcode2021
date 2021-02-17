package algo;

import datastructures.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return areChildrenSymmetric(root.left, root.right);
    }

    private boolean areChildrenSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null ^ t2 == null) {
            return false;
        }

        return t1.val == t2.val &&
                areChildrenSymmetric(t1.left, t2.right) && areChildrenSymmetric(t1.right, t2.left);
    }
}
