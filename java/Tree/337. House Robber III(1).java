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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int robHere = root.val;
        if (root.left != null) robHere += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) robHere += rob(root.right.left) + rob(root.right.right);

        int notRobHere = rob(root.left) + rob(root.right);

        return Math.max(robHere, notRobHere);
    }
}
