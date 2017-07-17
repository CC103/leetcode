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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        return helper(root, v, d, 1);

    }

    public TreeNode helper(TreeNode root, int v, int d, int height) {
        if (root == null) return null;
        if (height == d - 1) {
            TreeNode l = new TreeNode(v);
            l.left = root.left;
            TreeNode r = new TreeNode(v);
            r.right = root.right;

            root.left = l;
            root.right = r;
        }
        else {
            root.left = helper(root.left, v, d, height + 1);
            root.right = helper(root.right, v, d, height + 1);
        }

        return root;
    }
}
