// Binary search

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int numsWithoutDup[] = new int[nums.length];
        numsWithoutDup[0] = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) numsWithoutDup[count++] = nums[i];
        }

        int l = 0, r = count - 1;

        while(l < r) {
            int m = (l + r) / 2;
            if(numsWithoutDup[m] < numsWithoutDup[r]) r = m;
            else l = m + 1;
        }

        return numsWithoutDup[l];
    }
}
