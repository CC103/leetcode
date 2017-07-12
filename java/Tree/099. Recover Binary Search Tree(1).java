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
    private TreeNode fir = null;
    private TreeNode sec = null;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = fir.val;
        fir.val = sec.val;
        sec.val = temp;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        if (fir == null && pre.val > root.val) {
            fir = pre;
        }

        // the sec will be adjacent element for fir first, then be updated. this is to avoid missing sec.
        if (fir != null && pre.val > root.val) sec = root;

        pre = root;
        traverse(root.right);
    }
}
