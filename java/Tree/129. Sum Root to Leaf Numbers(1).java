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
    public int sumNumbers(TreeNode root) {
        List<Integer> paths = new ArrayList<>();

        if (root == null) return 0;
        helper(paths, root.val, root);

        int sum = 0;
        for (int i: paths) {
            sum += i;
        }

        return sum;
    }

    public void helper(List<Integer> paths, int sum, TreeNode root) {
        if (root.right == null && root.left == null) {
            paths.add(sum);
            return;
        }

        if (root.left != null) {
            helper(paths, sum * 10 + root.left.val, root.left);
        }

        if (root.right != null) {
            helper(paths, sum * 10 + root.right.val, root.right);
        }
    }
}
