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
        helper(root);
        return max;

    }

    public int[] helper(TreeNode root) {
        if (root == null) return new int[2];

        int increase = 1, decrease = 1;

        if (root.left != null) {
            int[] l = helper(root.left);
            if (root.val == root.left.val + 1) {
                decrease = l[1] + 1;
            } else if (root.val == root.left.val - 1) {
                increase = l[0] + 1;
            }
        }

        if (root.right != null) {
            int[] r = helper(root.right);
            if (root.val == root.right.val + 1) {
                decrease = Math.max(decrease, r[1] + 1);
            } else if (root.val == root.right.val - 1) {
                increase = Math.max(increase, r[0] + 1);
            }
        }

        max = Math.max(increase + decrease - 1, max);

        return new int[] {increase, decrease};
    }
}
