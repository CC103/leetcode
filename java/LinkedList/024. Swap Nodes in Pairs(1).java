class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fir = head;
        ListNode sec = head.next;
        ListNode pre = null;
        head = sec;
        while(fir != null && sec != null) {
            if(pre != null) pre.next = sec;
            fir.next = sec.next;
            pre = fir;
            sec.next = fir;
            fir = fir.next;
            if(fir != null) sec = fir.next;
        }

        return head;

    }
}
