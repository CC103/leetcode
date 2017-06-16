
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode l = left;
        ListNode r = right;
        while(head != null) {
            if(head.val >= x) {
                r.next = new ListNode(head.val);
                r = r.next;
            }
            else {
                l.next = new ListNode(head.val);
                l = l.next;
            }
            head = head.next;
        }

        l.next = right.next;

        return left.next;
    }
}
