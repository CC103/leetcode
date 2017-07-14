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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode root, int preSum, int sum) {
        if (root == null) return 0;
        int cur = preSum + root.val;

        return (cur == sum ? 1 : 0) + helper(root.left, cur, sum) + helper(root.right, cur, sum);

    }
}
