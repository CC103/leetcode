class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iter = dummy;

        while(iter != null) {
            while(iter.next != null && iter.next.val == val) iter.next = iter.next.next;
            iter = iter.next;
        }
        return dummy.next;

    }
}
