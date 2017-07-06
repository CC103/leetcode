public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;

        int tails[] = new int[nums.length + 1];
        tails[0] = Integer.MIN_VALUE;
        tails[1] = nums[0];

        int last = 1;

        for(int n: nums) {
            int size = last;
            for(int i = 1; i <= size; i++) {

                if(i == last && n > tails[i]) tails[++last] = n;

                if (n > tails[i - 1] && n < tails[i]) {
                    tails[i] = n;
                }
            }

        }

        return last;
    }
}
