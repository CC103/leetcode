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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int nodes = 0;
        int h = getHeight(root);

        while(root != null) {
            // left tree is completed, height = h - 1
            if (getHeight(root.right) == h - 1) {
                // left tree + root
                nodes += 1 << h;
                root = root.right;
            }
            // right tree is completed, height = h - 2
            else {
                // right tree + root
                nodes += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }

        return nodes;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return -1;
        return getHeight(root.left) + 1;
    }
}
