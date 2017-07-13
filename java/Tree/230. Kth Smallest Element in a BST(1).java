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
    public int kthSmallest(TreeNode root, int k) {
        int l = count(root.left);
        if (k <= l) return kthSmallest(root.left, k);
        else if (k > l + 1) return kthSmallest(root.right, k - l - 1);

        // k == l + 1;
        return root.val;

    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        int l = count(root.left);
        int r = count(root.right);
        return l + r + 1;
    }
}
