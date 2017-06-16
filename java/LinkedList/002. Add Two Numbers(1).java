
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        int carry = 0;
        while(l1 != null || l2 != null) {
            res.next = new ListNode(0);
            res = res.next;
            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = val / 10;
            val %= 10;
            res.val = val;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry == 1) res.next = new ListNode(1);
        return head.next;

    }
}
