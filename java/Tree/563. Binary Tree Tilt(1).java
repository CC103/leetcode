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
    private int tilt = 0;
    public int findTilt(TreeNode root) {
        getSum(root);
        return tilt;

    }

    public int getSum(TreeNode root) {
        if (root == null) return 0;

        int l = getSum(root.left);
        int r = getSum(root.right);
        int t = Math.abs(l - r);

        tilt += t;

        return l + r + root.val;
    }
}
