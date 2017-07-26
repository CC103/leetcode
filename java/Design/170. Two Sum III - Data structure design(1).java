import java.util.*;

public class TwoSum {
    Set<Integer> set;
    Set<Integer> num;

    /** Initialize your data structure here. */
    public TwoSum() {
        set = new HashSet<>();
        num = new HashSet<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        // avoid duplicate computation
        if (num.contains(number)) set.add(number + number);
        else {
            for (int i: num) set.add(number + i);
            num.add(number);
        }

    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return set.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
