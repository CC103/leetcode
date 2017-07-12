import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Codec {
    private static final String nullNode = "N";
    private static final String spliter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();

    }

    public void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) sb.append(nullNode).append(spliter);
        else {
            sb.append(root.val).append(spliter);
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    public TreeNode buildTree(Deque<String> nodes) {
        String s = nodes.remove();
        if (s.equals(nullNode)) return null;

        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
