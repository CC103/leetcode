class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(l1 != null && l2 != null) {
            tail.next = new ListNode(0);
            tail = tail.next;
            if(l1.val <= l2.val) {
                tail.val = l1.val;
                l1 = l1.next;
            }
            else {
                tail.val = l2.val;
                l2 = l2.next;
            }
        }

        if(l1 != null) tail.next = l1;
        else tail.next = l2;

        return head.next;

    }
}
