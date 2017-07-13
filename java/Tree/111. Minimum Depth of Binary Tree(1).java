import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        int min[] = new int[1];
        min[0] = Integer.MAX_VALUE;

        if (root == null) return 0;
        helper(min, 1, root);
        return min[0];
    }

    public void helper(int[] min, int depth, TreeNode root) {
        if (depth >= min[0]) return;

        // leaf node
        if (root.left == null && root.right == null) min[0] = Math.min(depth, min[0]);

        if (root.left != null) helper(min, depth + 1, root.left);
        if (root.right != null) helper(min, depth + 1, root.right);
    }
}
