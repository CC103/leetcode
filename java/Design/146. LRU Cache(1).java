import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;

        DLinkedNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    // add node right after head
    private void addNode(DLinkedNode node) {
        node.post = head.post;
        node.pre = head;
        head.post.pre = node;
        head.post = node;
    }

    private void moveToHead(DLinkedNode node) {
        // remove
        node.pre.post = node.post;
        node.post.pre = node.pre;

        // add
        node.post = head.post;
        head.post.pre = node;

        node.pre = head;
        head.post = node;
    }

    // return the key
    private int removeFromTail() {
        DLinkedNode n = tail.pre;
        n.pre.post = tail;
        tail.pre = n.pre;
        return n.key;
    }

    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head, tail;
    private int capacity, count;


    public LRUCache(int capacity) {
        cache = new HashMap<>();

        head = new DLinkedNode(0, 0);
        tail = new DLinkedNode(0, 0);
        head.post = tail;
        tail.pre = head;

        this.capacity = capacity;
        count = 0;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            // update the freshness
            moveToHead(node);

            return node.value;
        } else return -1;

    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode n = new DLinkedNode(key, value);
            addNode(n);
            cache.put(key, n);
            count++;

            if (count > capacity) {
                int k = removeFromTail();
                cache.remove(k);
                count--;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
