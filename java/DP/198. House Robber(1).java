public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        int len = nums.length;
        int max[] = new int[len];
        max[len - 1] = nums[len - 1];
        max[len - 2] = Math.max(nums[len - 1], nums[len - 2]);


        for(int i = nums.length - 3; i >= 0; i--) {
            max[i] = Math.max(nums[i] + max[i + 2], max[i + 1]);
        }

        return max[0];

    }
}
