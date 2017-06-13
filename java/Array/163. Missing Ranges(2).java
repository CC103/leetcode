import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int next = lower;
        List<String> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < next) continue;

            if(nums[i] == next) {
                if(next == Integer.MAX_VALUE) return res;
                next++;
            }
            else {
                if(nums[i] == next + 1) {
                    res.add(next + "");
                }
                else {
                    res.add(next + "->" + (nums[i] - 1));
                }
                if(nums[i] == Integer.MAX_VALUE) return res;
                next = nums[i] + 1;
            }
        }
        if(next == upper) res.add(next + "");
        else if(next < upper) res.add(next + "->" + upper);

        return res;
    }
}
