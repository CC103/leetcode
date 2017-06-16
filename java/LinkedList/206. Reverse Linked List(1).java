class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode tail = slow;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            tail = slow;
            slow = slow.next;
        }

        tail.next = null;
        ListNode r = reverseList(slow);
        while(head != null && r != null) {
            if(head.val != r.val) return false;
            head = head.next;
            r = r.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode a = head;
        ListNode b = head.next;
        if(b == null) return head;

        a.next = null;
        ListNode c = b.next;

        while(c != null) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;

        return b;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(2);

        a.next = b;
        b.next = c;
        c.next = d;

        Solution s = new Solution();
        s.isPalindrome(a);
    }
}
