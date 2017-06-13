// hashmap
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i: map.keySet()) {
            if(k == 0) {
                count += map.getOrDefault(i, 0) > 1 ? 1 : 0;
            }
            else{
                if(map.containsKey(i + k)) count++;
            }
        }
        return count;
    }
}
