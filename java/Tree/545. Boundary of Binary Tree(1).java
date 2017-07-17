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
    List<Integer> res;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);

        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return res;
    }

    public void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left != null) leftBoundary(root.left);
        else leftBoundary(root.right);
    }

    public void rightBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right != null) rightBoundary(root.right);
        else rightBoundary(root.left);

        // anti-clock
        res.add(root.val);
    }

    public void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(root.val);
        else {
            leaves(root.left);
            leaves(root.right);
        }

    }
}
