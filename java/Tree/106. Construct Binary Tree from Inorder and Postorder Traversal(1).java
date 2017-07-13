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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;

        TreeNode root = new TreeNode(postorder[e2]);

        int index = 0;
        for (int i = s1; i <= e1; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        int size = index - s1;

        root.left = helper(inorder, postorder, s1, index - 1, s2, s2 + size - 1);
        root.right = helper(inorder, postorder, index + 1, e1, s2 + size, e2 - 1);

        return root;
    }
}
