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

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }


    public int height(TreeNode root) {
        if (root == null) return -1;

        int l = height(root.left) + 1;
        int r = height(root.right) + 1;

        int d = l + r;
        if (max < d) max = d;

        return Math.max(l, r);
    }
}
