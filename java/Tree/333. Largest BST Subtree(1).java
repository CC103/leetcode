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
    public int largestBSTSubtree(TreeNode root) {
        if (isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) return countNodes(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    public boolean isBST(TreeNode root, long start, long end) {
        if (root == null) return true;
        if (root.val <= start || root.val >= end) return false;
        return isBST(root.left, start, root.val) && isBST(root.right, root.val, end);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
