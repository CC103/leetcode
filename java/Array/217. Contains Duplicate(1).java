// hashMap
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i: nums) {
            if(hashMap.containsKey(i)) {
                return true;
            }
            else hashMap.put(i, 1);
        }
        return false;
    }
}
