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
    public boolean verifyPreorder(int[] preorder) {

        return helper(preorder, 0, preorder.length - 1);
    }

    public boolean helper(int[] preorder, int s, int e) {
        if (s > e) return true;
        int root = preorder[s];
        // default right tree is empty
        int right = e + 1;

        for (int i = s + 1; i <= e; i++) {
            if (preorder[i] > root) {
                right = i;
                break;
            }
        }

        for (int j = right; j <= e; j++) {
            if (preorder[j] <= root) return false;
        }

        return helper(preorder, s + 1, right - 1) && helper(preorder, right, e);
    }
}
