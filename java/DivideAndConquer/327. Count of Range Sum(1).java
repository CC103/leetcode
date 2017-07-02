// easy way n2
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            long sum = nums[i];
            if(sum >= lower && sum <= upper) count++;

            for(int j = i + 1; j < nums.length; j++) {
                long val = sum + nums[j];
                if(val >= lower && val <= upper) count++;

                sum = val;
            }
        }

        return count;

    }
}
