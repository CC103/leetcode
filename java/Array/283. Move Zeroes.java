// Array
public class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0, first = 0, second = 0;
        for(; second < nums.length; second++) {
            if(nums[second] != 0) {
                nums[first] = nums[second];
                first++;
            }
            else{
                count++;
            }
        }
        int len = nums.length;
        for(int i = 0; i < count; i++) {
            nums[len - 1 - i] = 0;
        }
    }
}
