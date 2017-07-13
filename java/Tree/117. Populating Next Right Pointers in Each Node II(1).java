import java.util.*;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;

        while (cur != null) {

            // iterate on the current level
            while (cur != null) {
                // left
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else head = cur.left;
                    pre = cur.left;
                }

                // right
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else head = cur.right;

                    pre = cur.right;
                }

                cur = cur.next;
            }
            cur = head;
            head = null;
            pre = null;
        }
    }
}
