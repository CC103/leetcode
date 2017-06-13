import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                for(int m = j + 1; m < nums.length; m++) {
                    if(nums[m] < sum) count++;
                    else break;
                }

            }
        }
        return count;

    }
}
