import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode node: lists) {
            if(node != null) queue.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next != null) queue.add(tail.next);
        }

        return dummy.next;

    }
    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode arr[] = {a, b};
        Solution s = new Solution();
        ListNode head = s.mergeKLists(arr);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
