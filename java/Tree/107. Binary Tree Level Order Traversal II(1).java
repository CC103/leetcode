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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < num; i++) {
                TreeNode cur = queue.poll();
                row.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            res.add(0, row);
        }
        return res;
    }
}
