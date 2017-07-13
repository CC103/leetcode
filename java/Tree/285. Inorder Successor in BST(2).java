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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (p.val >= root.val) return inorderSuccessor(root.right, p);
        else {
            TreeNode l = inorderSuccessor(root.left, p);
            return l == null ? root : l;
        }
    }
}
