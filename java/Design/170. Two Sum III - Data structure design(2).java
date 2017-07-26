import java.util.*;

public class TwoSum {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) map.put(number, 2);
        else map.put(number,1 );

    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i: map.keySet()) {
            int com = value - i;
            if (com != i && map.containsKey(com)) return true;
            if (com == i && map.get(i) == 2) return true;
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
