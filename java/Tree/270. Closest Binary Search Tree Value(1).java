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
    public int closestValue(TreeNode root, double target) {
        double diff = Math.abs(root.val - target);
        int node = root.val;

        while (root != null) {
            double temp = Math.abs(root.val - target);
            if (temp < diff) {
                diff = temp;
                node = root.val;
            }

            if (target > root.val) root = root.right;
            else if (target <  root.val) root = root.left;
            else return node;
        }

        return node;
    }
}
