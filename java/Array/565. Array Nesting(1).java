// HashSet; ETL
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int arrayNesting(int[] nums) {
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++) {
            int count = 1;
            int cur = nums[i];
            Set<Integer> map = new HashSet<>();
            map.add(cur);

            while(!map.contains(nums[cur])) {
                cur = nums[cur];
                map.add(cur);
                count++;
            }

            maxLength = Math.max(maxLength, count);
        }

        return maxLength;

    }
}
