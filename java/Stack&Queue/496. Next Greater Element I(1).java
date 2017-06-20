public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int res[] = new int[findNums.length];
        for(int i = 0; i < findNums.length; i++) {
            int n = findNums[i];
            for(int j = 0; j < nums.length; j++) {
                boolean flag = false;
                if(nums[j] == n) {
                    for(int p = j + 1; p < nums.length; p++) {
                        if(nums[p] > n) {
                            res[i] = nums[p];
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) res[i] = -1;
                    break;
                }
            }
        }
        return res;

    }
}
