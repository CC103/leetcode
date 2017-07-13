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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode cur = root;

        while (cur != null) {
            next = cur.left;

            // swapping nodes now, need temp to keep the previous right child
            cur.left = temp;
            temp = cur.right;
            cur.right = prev;

            prev = cur;
            cur = next;
        }

        return prev;

    }
}
