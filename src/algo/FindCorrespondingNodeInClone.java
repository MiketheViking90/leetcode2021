package algo;

import datastructures.TreeNode;

public class FindCorrespondingNodeInClone {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (!(original != null && cloned != null)) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode lNode = getTargetCopy(original.left, cloned.left, target);
        TreeNode rNode = getTargetCopy(original.right, cloned.right, target);
        if (lNode != null) {
            return lNode;
        }
        return rNode;
    }
}
