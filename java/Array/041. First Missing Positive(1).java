// HashTable
import java.util.*;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i: nums) {
            if(i > 0) {
                set.add(i);
                count++;
            }
        }
        for(int i = 1; i < count + 1; i++) {
            if(!set.contains(i)) return i;
        }

        // The first missing number is greater than max
        // eg: 1,2,3,4 return 5
        return count + 1;
    }
}
