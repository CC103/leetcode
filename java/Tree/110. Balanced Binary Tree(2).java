class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int l = getHeight(root.left);
        if(l == - 1) return -1;
        int r = getHeight(root.right);
        if(r == -1) return -1;

        if (Math.abs(l - r) > 1) return -1;
        else return Math.max(l, r) + 1;
    }
}
