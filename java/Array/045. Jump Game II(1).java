public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;

        int scope = nums[0];
        int jump = 0;

        if(scope >= nums.length - 1) return jump + 1;

        for(int i = 0; i < nums.length - 1;) {
            int max = 0, index = 0;
            for(int j = i + 1; j <= scope; j++) {
                int newScope = nums[j] + j;
                if(newScope > scope && newScope > max) {
                    max = newScope;
                    index = j;
                }
            }

            jump++;
            scope = max;
            i = index;

            if(scope >= nums.length - 1) break;
        }

        return jump + 1;
    }
}
