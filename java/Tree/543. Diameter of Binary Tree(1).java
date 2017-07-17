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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Map<TreeNode, Integer> memory = new HashMap<>();
        int d = findDiameter(memory, root.left) + findDiameter(memory, root.right) + 2;
        if (d > max) max = d;

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return max;
    }


    public int findDiameter(Map<TreeNode, Integer> memory, TreeNode root) {
        if (root == null) return -1;

        if (memory.containsKey(root)) return memory.get(root);

        int d = Math.max(findDiameter(memory, root.left), findDiameter(memory, root.right)) + 1;
        memory.put(root, d);

        return d;
    }
}
