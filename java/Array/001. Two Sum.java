import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(hashMap.containsKey(complement)) {
                int ret[] = {hashMap.get(complement), i};
                return ret;
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Result");
    }

    public static void main(String[] args){}
}
