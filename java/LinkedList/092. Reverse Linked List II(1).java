import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode l = dummy;
        ListNode r = dummy;

        // l是翻转区域的上一个node，r是下一个node
        while(m-- > 1) {
            l = l.next;
        }

        while(n-- > 0) {
            r = r.next;
        }
        // truncate
        ListNode p = r.next;
        r.next = null;
        r = p;

        List<ListNode> headAndTail = reverse(l.next);
        l.next = headAndTail.get(0);
        headAndTail.get(1).next = r;

        return dummy.next;

    }

    public List<ListNode> reverse(ListNode h) {
        List<ListNode> res = new ArrayList<>();
        if(h == null || h.next == null) {
            res.add(h);
            res.add(h);
            return res;
        }

        ListNode tail = h;

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

        res.add(b);
        res.add(tail);
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
//        ListNode c = new ListNode(0);
//        ListNode d = new ListNode(2);

        a.next = b;
//        b.next = c;
//        c.next = d;

        Solution s = new Solution();
        s.reverseBetween(a, 1, 2);
    }
}
