class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = slow;

        while(fast != null && fast.next != null) {
            tail = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        // truncate
        tail.next = null;
        ListNode l = reverse(slow);
        ListNode next;
        ListNode lNext;

        ListNode out1 = head;
        ListNode out2 = l;


        while(out1 != null) {
            System.out.println(out1.val);
            out1 = out1.next;
        }
        System.out.println("--------------");
        while(out2 != null) {
            System.out.println(out2.val);
            out2 = out2.next;
        }
        System.out.println("--------------");


        ListNode out3 = head;
        ListNode tail2 = head;
        while(head != null && l != null) {
            next = head.next;
            lNext = l.next;

            head.next = l;
            l.next = next;

            tail2 = head.next;
            head = next;
            l = lNext;
        }

        if(l != null) tail2.next = l;

        while(out3 != null) {
            System.out.println(out3.val);
            out3 = out3.next;
        }

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

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);


        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;

        Solution s = new Solution();
        s.reorderList(a);
    }
}
