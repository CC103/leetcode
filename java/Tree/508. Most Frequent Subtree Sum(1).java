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

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        SubtreeSum(root, map);
        List<Integer> l = new ArrayList<>();

        int max = 0;
        for (Map.Entry m : map.entrySet()) {
            if ((int) m.getValue() > max) {
                max = (int) m.getValue();
                l.clear();
                l.add((int) m.getKey());
            } else if ((int) m.getValue() == max) l.add((int) m.getKey());
        }

        int res[] = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }

        return res;
    }

    public int SubtreeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;

        int sum = root.val + SubtreeSum(root.left, map) + SubtreeSum(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }
}
