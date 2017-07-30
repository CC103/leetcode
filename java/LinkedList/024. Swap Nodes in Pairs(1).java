class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fir = head;
        ListNode sec = head.next;

        ListNode dummy = new ListNode(0);
        dummy.next = fir;
        ListNode pre = dummy;

        while (fir != null && sec != null) {
            pre.next = sec;
            fir.next = sec.next;
            sec.next = fir;

            pre = fir;
            fir = fir.next;
            if (fir != null) {
                sec = fir.next;
            }
        }

        return dummy.next;
    }
}
