class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) return root;
        if(p.val == root.val || q.val == root.val) return root;

        TreeNode iter = root;

        pathP.add(root);
        while(iter.val != p.val) {
            if(p.val < iter.val) iter = iter.left;
            else iter = iter.right;

            pathP.add(iter);
        }
        pathP.add(iter);

        iter = root;
        pathQ.add(root);
        while(iter.val != q.val) {
            if(q.val < iter.val) iter = iter.left;
            else iter = iter.right;

            pathQ.add(iter);
        }
        pathQ.add(iter);

        int i = 0;
        while(pathP.get(i + 1) == pathQ.get(i + 1)) {
            i++;
        }

        return pathP.get(i);
    }
}
