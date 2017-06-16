
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode a = head;
        ListNode b = head.next;
        if(b == null) return head;

        a.next = null;
        ListNode c = b.next;

        while(c != null) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;

        return b;

    }
}
