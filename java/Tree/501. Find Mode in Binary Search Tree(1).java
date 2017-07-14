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
    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> l = new ArrayList<>();
        helper(root, l);

        int res[] = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }

        return res;
    }

    public void helper(TreeNode root, List<Integer> l) {
        if (root == null) return;

        helper(root.left, l);
        if (prev != null) {
            if (prev == root.val) count++;
            else count = 1;
        }

        if (count > max) {
            max = count;
            l.clear();
            l.add(root.val);
        } else if (count == max) l.add(root.val);

        prev = root.val;
        helper(root.right, l);
    }
}
