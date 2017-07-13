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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> seq = new ArrayList<>();
        Dfs(root, seq);
        for (int i = 0; i < seq.size() - 1; i++) {
            if (seq.get(i) == p) return seq.get(i + 1);
        }

        return null;
    }

    public void Dfs(TreeNode root, List<TreeNode> seq) {
        if (root == null) return;

        if (root.left != null) Dfs(root.left, seq);
        seq.add(root);
        if (root.right != null) Dfs(root.right, seq);
    }
}
