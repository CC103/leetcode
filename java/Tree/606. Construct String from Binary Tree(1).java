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
    public String tree2str(TreeNode t) {
        if (t == null) return "";

        String l = tree2str(t.left);
        String r = tree2str(t.right);

        StringBuilder sb = new StringBuilder();
        if (l.equals("")&& r.equals("")) sb.append(t.val);

        // right is null, no need for ()
        else if(r.equals("")) sb.append(t.val).append('(').append(l).append(')');

        else sb.append(t.val).append('(').append(l).append(')').append('(').append(r).append(')');

        return sb.toString();
    }
}
