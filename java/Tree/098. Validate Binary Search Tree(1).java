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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long start, long end) {
        if (root == null) return true;
        if (root.val <= start || root.val >= end) return false;
        return helper(root.left, start, root.val) && helper(root.right, root.val, end);
    }
}
