/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return(reverse(addTwo(reverse(l1), reverse(l2))));

    }

    public ListNode reverse(ListNode h) {
        if(h == null || h.next == null) return h;
        ListNode a = h;
        ListNode b = a.next;
        ListNode c = b.next;
        a.next = null;
        while(c != null) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;
        return b;
    }

    public ListNode addTwo(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;

        while(l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            int val = sum % 10;
            iter.next = new ListNode(val);
            iter = iter.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry == 1) iter.next = new ListNode(1);

        return dummy.next;

    }
}
