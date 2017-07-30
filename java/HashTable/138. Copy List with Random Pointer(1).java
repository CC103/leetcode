import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        Map<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(newHead.label, newHead);

        RandomListNode iter = newHead;
        RandomListNode nextNode = head.next;

        // build next
        while(nextNode != null) {
            iter.next = new RandomListNode(nextNode.label);
            iter = iter.next;
            map.put(iter.label, iter);
            nextNode = nextNode.next;
        }

        // reset
        iter = newHead;
        nextNode = head;

        // build random
        while(nextNode != null) {
            if(nextNode.random == null) iter.random = null;
            else iter.random = map.get(nextNode.random.label);
            iter = iter.next;
            nextNode = nextNode.next;
        }

        return newHead;
    }
}
