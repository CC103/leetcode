import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AllOne {

    private class KeyValue {
        String key;
        int value = 1;
        public KeyValue(String key) {
            this.key = key;
        }
    }

    Map<String, KeyValue> map;
    PriorityQueue<KeyValue> maxQueue;
    PriorityQueue<KeyValue> minQueue;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        maxQueue = new PriorityQueue<>((a, b) -> (b.value - a.value));
        minQueue = new PriorityQueue<>((a, b) -> (a.value - b.value));
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            KeyValue k = map.get(key);
            maxQueue.remove(k);
            minQueue.remove(k);

            k.value++;
            minQueue.add(k);
            maxQueue.add(k);
        }
        else {
            KeyValue k = new KeyValue(key);
            map.put(key, k);
            maxQueue.add(k);
            minQueue.add(k);
        }

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        KeyValue k = map.get(key);
        maxQueue.remove(k);
        minQueue.remove(k);

        k.value--;
        if (k.value == 0) map.remove(key);
        else {
            minQueue.add(k);
            maxQueue.add(k);
        }

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (map.isEmpty()) return "";
        return maxQueue.peek().key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (map.isEmpty()) return "";
        return minQueue.peek().key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
