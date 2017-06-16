public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode tail = head;

        while(fast != null && fast.next != null) {
            tail = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        // cut off
        tail.next = null;

        /*ListNode a = head;
        while(a != null) {
            System.out.println(a.val);
            a = a.next;
        }
        a = slow;
        System.out.println("----");
        while(a != null) {
            System.out.println(a.val);
            a = a.next;
        }*/



        ListNode l = sortList(head);
        ListNode r = sortList(slow);

        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(l != null && r != null) {
            if(l.val <= r.val) {
                tail.next = l;
                l = l.next;
            }
            else {
                tail.next = r;
                r = r.next;
            }
            tail = tail.next;
        }
        if(l != null) tail.next = l;
        if(r != null) tail.next = r;

        return head.next;
    }

    /*public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution s = new Solution();
        s.sortList(node1);


    }*/
}
