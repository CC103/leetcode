import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BSTIterator {

    public BSTIterator(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode root) {
        if(root == null) return;
        helper(root.right);
        stack.push(root.val);
        helper(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.empty()) return false;
        return true;

    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }

    private Stack<Integer> stack = new Stack<>();
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
