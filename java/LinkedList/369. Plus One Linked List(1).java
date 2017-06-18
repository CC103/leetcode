import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while(head != null) {
            s.push(head.val);
            head = head.next;
        }

        int sum = 1;
        ListNode cur = new ListNode(0);
        while(!s.empty()) {
            sum += s.pop();
            cur.val = sum % 10;
            sum /= 10;
            ListNode h = new ListNode(sum);
            h.next = cur;
            cur = h;
        }

        return cur.val == 0 ? cur.next : cur;

    }
}
