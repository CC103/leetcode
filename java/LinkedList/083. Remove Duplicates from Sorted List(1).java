class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode iter = head;
        while(iter != null) {
            while(iter.next != null && iter.next.val == iter.val) iter.next = iter.next.next;
            iter = iter.next;
        }
        return head;
    }
}
