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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;

        int val = preorder[s1];
        TreeNode root = new TreeNode(val);
        int mid = 0;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == val) {
                mid = i;
                break;
            }
        }

        int size = mid - s2;
        root.left = helper(preorder, inorder, s1 + 1, s1 + size, s2, mid - 1);
        root.right = helper(preorder, inorder, s1 + size + 1, e1, mid + 1, e2);
        return root;
    }
}
