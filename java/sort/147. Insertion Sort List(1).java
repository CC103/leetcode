/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;

            while (iter.next != null && iter.next.val < cur.val) {
                iter = iter.next;
            }
            cur.next = iter.next;
            iter.next = cur;
            cur = next;
            iter = dummy;
        }

        return dummy.next;
    }
}
