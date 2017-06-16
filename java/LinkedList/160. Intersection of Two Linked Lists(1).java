
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        int lenA = 0;
        ListNode b = headB;
        int lenB = 0;
        while(a  != null) {
            lenA++;
            a = a.next;
        }

        while(b != null) {
            lenB++;
            b = b.next;
        }

        int diff = Math.abs(lenA - lenB);
        if(lenA > lenB) {
            a = headA;
            while(diff-- > 0) {
                a = a.next;
            }
            b = headB;
        }
        else {
            b = headB;
            while(diff-- > 0) {
                b = b.next;
            }
            a = headA;
        }
        while(a != b) {
            a = a.next;
            b = b.next;
        }

        return a;

    }
}
