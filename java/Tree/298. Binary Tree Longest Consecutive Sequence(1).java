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
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;

        int cur = 0;
        helper(root, root.val, cur);
        return max;
    }

    public void helper(TreeNode root, int target, int cur) {
        if (root == null) return;

        if (root.val == target) {
            cur++;
            max = Math.max(max, cur);
        }
        else cur = 1;

        helper(root.left, root.val + 1, cur);
        helper(root.right, root.val + 1, cur);
    }
}
