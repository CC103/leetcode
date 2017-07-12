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
    public void flatten(TreeNode root) {
        if(root == null) return;
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if(root.left == null && root.right == null) return root;

        TreeNode l = null;
        TreeNode r = null;
        if(root.left != null) l = helper(root.left);
        if(root.right != null) r = helper(root.right);

        root.left = null;
        root.right = null;

        if(l != null) {
            root.right = l;
            TreeNode iter = root;
            while(iter.right != null) iter = iter.right;

            iter.right = r;
        }
        else root.right = r;

        return root;
    }
}
