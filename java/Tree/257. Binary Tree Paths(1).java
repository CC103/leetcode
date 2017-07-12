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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        String str = root.val + "";
        helper(res, str, root);

        return res;

    }

    public void helper(List<String> res, String str, TreeNode root) {
        if(root.left == null && root.right == null) {
            res.add(str);
            return;
        }

        if(root.left != null) helper(res, str + "->" + root.left.val, root.left);
        if(root.right != null) helper(res, str + "->" + root.right.val, root.right);
    }
}
