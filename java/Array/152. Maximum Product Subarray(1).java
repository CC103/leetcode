public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int maxPre = nums[0], minPre = nums[0];
        int max = maxPre, min = minPre;
        for(int i = 1; i < nums.length; i++) {
            int maxHere = Math.max(nums[i], Math.max(nums[i] * maxPre, nums[i] * minPre));
            int minHere = Math.min(nums[i], Math.min(nums[i] * maxPre, nums[i] * minPre));

            max = max > maxHere ? max : maxHere;
            min = min < minHere ? min : minHere;

            maxPre = maxHere;
            minPre = minHere;
        }
        return max;
    }
}
