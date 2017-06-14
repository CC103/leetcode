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

        RandomListNode l = new RandomListNode(head.label);
        RandomListNode r = l;
        RandomListNode nextNode = head.next;
        Map<Integer, RandomListNode> map = new HashMap<>();
        map.put(l.label, l);

        while(nextNode != null) {
            r.next = new RandomListNode(nextNode.label);
            r = r.next;
            map.put(r.label, r);

            nextNode = nextNode.next;
        }

        r = l;
        nextNode = head;

        while(nextNode != null) {
            if(nextNode.random == null) r.random = null;
            else r.random = map.get(nextNode.random.label);
            r = r.next;
            nextNode = nextNode.next;
        }

        return l;
    }
}
