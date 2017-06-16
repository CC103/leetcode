
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;

        ListNode fast = virtualHead;
        ListNode slow = virtualHead;

        // circle
        int len = 0;
        ListNode travel = head;
        while(travel != null) {
            len++;
            travel = travel.next;
        }

        k = k % len;


        while(k > 0) {
            fast = fast.next;
            k--;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;

    }
}
