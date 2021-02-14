package algo;

import datastructures.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }

        boolean isSameVal = s.val == t.val;
        if (isSameVal) {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }
}
