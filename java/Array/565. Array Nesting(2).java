public class Solution {
    public int arrayNesting(int[] nums) {
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) continue;
            int count = 1, val = nums[i];
            nums[i] *= -1;
            while(i != Math.abs(val)) {
                count++;
                nums[Math.abs(val)] *= -1;
                val = nums[Math.abs(val)];
            }
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;

    }
}
