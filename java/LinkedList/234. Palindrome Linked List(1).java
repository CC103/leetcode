class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        int mid = slow.val;
        int xor = 0;
        int len = 0;

        while(head != null) {
            len++;
            xor ^= head.val;
            head = head.next;
        }

        if(len % 2 == 0 && xor == 0) return true;
        else if(xor == mid) return true;

        return false;
    }
}
