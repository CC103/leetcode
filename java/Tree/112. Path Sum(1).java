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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum);
    }

    public boolean helper(TreeNode root, int target) {
        if (root == null) return false;

        target -= root.val;
        if(root.left == null && root.right == null && target == 0) return true;

        boolean flag = false;
        flag = helper(root.left, target);
        if(flag) return true;
        flag = helper(root.right, target);
        return flag;
    }

}
