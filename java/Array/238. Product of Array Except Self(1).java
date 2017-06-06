// Array; Time O(n) Space O(n)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        // [0,1,2...i-1]
        for(int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // [i+1, i+2....len-1]
        for(int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }

        int ret[] = new int[nums.length];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = left[i] * right[i];
        }

        return ret;
    }
}
