import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == 0) maxLen = i + 1;
            else {
                if(map.containsKey(sum)) maxLen = Math.max(maxLen, i - map.get(sum));
                else map.put(sum, i);
            }
        }

        return maxLen;
    }
}
