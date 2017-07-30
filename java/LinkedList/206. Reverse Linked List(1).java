
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode a = head;
        ListNode b = head.next;

        a.next = null;
        ListNode c = b.next;

        while (c != null) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;

        return b;
    }
}
