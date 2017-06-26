public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(i % 2 == 1) {
                if(nums[i] > nums[i - 1]) continue;;
            }
            else {
                if(nums[i] < nums[i - 1]) continue;;
            }

            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }
    }
}
