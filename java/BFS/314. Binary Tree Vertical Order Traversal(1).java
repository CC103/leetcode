import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Pair {
    TreeNode node;
    int col;

    Pair(int col, TreeNode node) {
        this.col = col;
        this.node = node;
    }
}

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            map.putIfAbsent(pair.col, new ArrayList<>());
            map.get(pair.col).add(pair.node.val);

            if (pair.node.left != null) queue.add(new Pair(pair.col - 1, pair.node.left));
            if (pair.node.right != null) queue.add(new Pair(pair.col + 1, pair.node.right));
        }

        int[] cols = new int[map.size()];

        int j = 0;
        for (int col : map.keySet()) {
            cols[j++] = col;
        }

        Arrays.sort(cols);
        List<List<Integer>> res = new ArrayList<>();

        for (int i : cols) res.add(map.get(i));
        return res;
    }
}
