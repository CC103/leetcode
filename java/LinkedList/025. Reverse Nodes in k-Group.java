class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        int len = 0;
        ListNode iter = head;
        while (iter != null && len != k) {
            len++;
            iter = iter.next;
        }

        if (len == k) {
            ListNode next = reverseKGroup(iter, k);

            while (len-- > 0) {
                ListNode tmp = head.next;
                head.next = next;
                next = head;
                head = tmp;
            }
            // head now is in next group, back one step
            head = next;
        }
        return head;
    }
}
