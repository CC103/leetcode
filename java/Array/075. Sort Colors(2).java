public class Solution {
    public void sortColors(int[] nums) {
        int nextZero = 0, nextTwo = nums.length - 1;
        for (int i = 0; i <= nextTwo; i++) {
            while (nums[i] == 2 && i <= nextTwo) {
                swap(nums, i, nextTwo);
                nextTwo--;
            }
            while (nums[i] == 0 && i >= nextZero) {
                swap(nums, i, nextZero);
                nextZero++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
