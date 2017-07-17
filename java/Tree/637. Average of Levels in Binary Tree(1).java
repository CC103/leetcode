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
    List<Double[]> list = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        helper(root, 0);
        List<Double> res = new ArrayList<>();

        for (Double[] arr: list) {
            System.out.println(arr[0] + " " + arr[1]);
            res.add(arr[0] / arr[1]);
        }

        return res;
    }

    public void helper(TreeNode root, int height) {
        if (root == null) return;
        if (list.size() == height) {
            Double arr[] = {0.0, 0.0};
            list.add(arr);
        }

        list.get(height)[0] += root.val;
        list.get(height)[1] += 1;

        helper(root.left, height + 1);
        helper(root.right, height + 1);
    }

    public static void main(String arg[]) {
        TreeNode a = new TreeNode(1);
        Solution s = new Solution();
        s.averageOfLevels(a);
    }
}
