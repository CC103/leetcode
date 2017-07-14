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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(0, root, res);
        return res;
    }

    public void helper(int level, TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (res.size() <= level) res.add(root.val);
        else res.set(level, Math.max(res.get(level), root.val));
        helper(level + 1, root.left, res);
        helper(level + 1, root.right, res);
    }
}
