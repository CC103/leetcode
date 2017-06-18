import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode candidate = head;
        int val = candidate.val;

        while(candidate != null) {
            if(candidate.next == null) {
                tail.next = candidate;
                tail = tail.next;
                break;
            }

            if(candidate.next.val != val) {
                tail.next = candidate;
                tail = tail.next;
                candidate = candidate.next;
                val = candidate.val;
            }
            else {
                while(candidate != null && candidate.val == val) {
                    candidate = candidate.next;
                }
                if(candidate != null) val = candidate.val;
            }
        }

        tail.next = null;
        return dummy.next;
    }
}
