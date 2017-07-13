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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) return res;

        temp.add(root.val);
        helper(res, temp, sum - root.val, root);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> temp, int target, TreeNode root) {
        if (root == null) return;

        // leaf node
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (root.left != null) {
            temp.add(root.left.val);
            helper(res, temp, target - root.left.val, root.left);
            temp.remove(temp.size() - 1);
        }

        if (root.right != null) {
            temp.add(root.right.val);
            helper(res, temp, target - root.right.val, root.right);
            temp.remove(temp.size() - 1);
        }

    }
}
