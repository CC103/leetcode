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
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }

    public int getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    public void helper(TreeNode root, int pre) {
        if (root == null) return;
        int add = pre + getSum(root.right);
        root.val += add;

        helper(root.right, pre);
        helper(root.left, root.val);
    }

}
