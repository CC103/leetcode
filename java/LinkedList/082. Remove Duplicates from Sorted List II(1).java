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
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        ListNode iter = head;

        while(iter != null) {
            if(set.contains(iter.val)) duplicate.add(iter.val);
            else set.add(iter.val);
            iter = iter.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        iter = head;
        while(iter != null) {
            if(!duplicate.contains(iter.val)) {
                tail.next = iter;
                tail = tail.next;
            }
            iter = iter.next;
        }
        tail.next = null;

        return dummy.next;
    }
}
