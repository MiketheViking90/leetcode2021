package datastructures;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode makeTree() {
        TreeNode tn10 = new TreeNode(10);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn8 = new TreeNode(8);
        TreeNode tn1 = new TreeNode(1);

        TreeNode tn15 = new TreeNode(15);
        TreeNode tn17 = new TreeNode(17);
        TreeNode tn19 = new TreeNode(19);

        tn10.left = tn5;
        tn10.right = tn15;

        tn5.left = tn3;
        tn5.right = tn8;

        tn3.left = tn1;

        tn15.right = tn17;
        tn17.right = tn19;

        return tn10;
    }
}
