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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum[] = new int[1];
        helper(sum, root);

        return sum[0];
    }

    public void helper(int[] sum, TreeNode root) {
        TreeNode l = root.left;
        TreeNode r = root.right;

        if (l != null ) {
            if (l.right == null && l.left == null) sum[0] += l.val;
            else helper(sum, l);
        }

        if (r != null) helper(sum, r);
    }
}
