
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        if (pre != null) pre.next = null;
        TreeNode root = new TreeNode(slow.val);

        if (slow == head) root.left = null;
        else root.left = sortedListToBST(head);

        root.right = sortedListToBST(slow.next);

        return root;

    }

    public static void main(String arg[]) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);


        a.next = b;
        b.next = c;
        c.next = d;

        Solution s = new Solution();
        s.sortedListToBST(a);

    }
}
