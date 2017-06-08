// Two pointers
import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;

        int fir, sec, last;
        int closest = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for(fir = 0; fir < nums.length - 2; fir++) {

            for(sec = fir + 1, last = nums.length - 1; sec < last;) {
                int sum = nums[fir] + nums[sec] + nums[last];
                if(sum < target) {
                    closest = Math.abs(target - sum) < Math.abs(target - closest) ? sum : closest;
                    sec++;
                }
                else if (sum > target) {
                    closest = Math.abs(target - sum) < Math.abs(target - closest) ? sum : closest;
                    last--;
                }
                else return target;
            }
        }

        return closest;

    }
}
