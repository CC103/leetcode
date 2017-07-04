public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int maxPre = nums[0];
        int minPre = nums[0];
        int max = maxPre;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = maxPre;
                maxPre = minPre;
                minPre = temp;
            }

            int maxHere = Math.max(nums[i], nums[i] * maxPre);
            int minHere = Math.min(nums[i], nums[i] * minPre);

            max = Math.max(max, maxHere);

            maxPre = maxHere;
            minPre = minHere;
        }

        return max;
    }
}
