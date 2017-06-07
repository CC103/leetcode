import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int maxLength = 0;

        for(int i: nums) {
            if(hashMap.containsKey(i)) continue;

            // Find the neighborhood
            int left = hashMap.containsKey(i - 1) ? hashMap.get(i - 1) : 0;
            int right = hashMap.containsKey(i + 1) ? hashMap.get(i + 1) : 0;
            int sum = left + right + 1;
            maxLength = maxLength > sum ? maxLength : sum;

            hashMap.put(i, sum);

            // Extend the length to the boundary of the sequence
            // Will do nothing if n has no neighbors
            if(left != 0) hashMap.put(i - left, sum);
            if(right != 0) hashMap.put(i + right, sum);
        }
        return maxLength;
    }
}
