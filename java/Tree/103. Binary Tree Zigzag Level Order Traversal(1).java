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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                if (leftToRight) level.add(cur.val);
                else level.add(0, cur.val);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;
    }
}
