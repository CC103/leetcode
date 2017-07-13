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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memory = new HashMap<>();
        return helper(memory, root);

    }

    public int helper(Map<TreeNode, Integer> memory, TreeNode root) {
        if (root == null) return 0;
        if (memory.containsKey(root)) return memory.get(root);

        int robHere = root.val;
        if (root.left != null) robHere += helper(memory, root.left.left) + helper(memory, root.left.right);
        if (root.right != null) robHere += helper(memory, root.right.left) + helper(memory, root.right.right);

        int notRobHere = helper(memory, root.left) + helper(memory, root.right);

        int max = Math.max(robHere, notRobHere);
        memory.put(root, max);

        return max;
    }
}
