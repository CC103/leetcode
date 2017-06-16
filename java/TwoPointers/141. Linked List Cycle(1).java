class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null) {
            if(fast == slow) return true;
            fast = fast.next;
            if(fast != null) fast = fast.next;
            else break;

            slow = slow.next;
        }

        return false;
    }
}
