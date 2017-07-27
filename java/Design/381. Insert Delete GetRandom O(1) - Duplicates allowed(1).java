import java.util.*;

public class RandomizedCollection {

    Random rand = new Random();
    Map<Integer, List<Integer>> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            int index = list.size();
            map.get(val).add(index);
            list.add(val);
            return false;
        }
        else {
            int index = list.size();
            List<Integer> l = new ArrayList<>();
            l.add(index);
            map.put(val, l);
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val).get(0);
        // last element
        if (index == list.size() - 1) {
            list.remove(index);
            map.get(val).remove(0);
            if (map.get(val).size() == 0) map.remove(val);
        }
        else {
            // swap with last element
            int last = list.get(list.size() - 1);
            list.set(index, last);

            int i = map.get(last).indexOf(list.size() - 1);
            map.get(last).remove(i);
            map.get(last).add(index);

            list.remove(list.size() - 1);

            map.get(val).remove(0);
            if (map.get(val).size() == 0) map.remove(val);
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
