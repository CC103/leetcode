//Moore voting algorithm
public class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                majority = nums[i];
                count++;
            }
            else{
                if(nums[i] != majority) {
                    count--;
                }
                else count++;
            }
        }
        return majority;
    }
}
