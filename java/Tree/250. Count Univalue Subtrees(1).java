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
    public int countUnivalSubtrees(TreeNode root) {
        int count[] = new int[1];
        helper(count, root);
        return count[0];

    }

    public boolean helper(int[] count, TreeNode root) {
        // make leaf node be counted
        if (root == null) return true;

        boolean l = helper(count, root.left);
        boolean r = helper(count, root.right);

        if (l && r) {
            if (root.left != null && root.val != root.left.val) return false;
            if (root.right != null && root.val != root.right.val) return false;
            count[0]++;
            return true;
        }
        return false;
    }
}
