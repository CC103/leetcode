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
        if(root == null) return true;
        int l = getHeight(root.left);
        int r = getHeight(root.right);

        if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(l - r) <= 1) return true;
        return false;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
