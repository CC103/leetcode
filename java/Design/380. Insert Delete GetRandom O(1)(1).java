import java.util.*;

public class RandomizedSet {

    Random rand = new Random();
    Map<Integer, Integer> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        int index = list.size();
        map.put(val, index);
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        // last element
        if (index == list.size() - 1) {
            list.remove(index);
            map.remove(val);
        }
        else {
            // swap with last element
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
            list.remove(list.size() - 1);
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
