public class Solution {
   public int findUnsortedSubarray(int[] nums) {
       int max = Integer.MIN_VALUE;
       int min = Integer.MAX_VALUE;
       int ifSorted[] = new int[nums.length];

       for(int i = 0; i < nums.length; i++) {
           if(nums[i] < max) ifSorted[i] = 1;
           max = Math.max(max, nums[i]);
       }

       for(int i = nums.length - 1; i >= 0; i--) {
           if(nums[i] > min) ifSorted[i] = 1;
           min = Math.min(min, nums[i]);
       }

       int l = -1, r = -1;
       for(int i = 0; i < nums.length; i++) {
           if(ifSorted[i] == 1) {
               l = i;
               break;
           }
       }

       for(int i = nums.length - 1; i >= 0; i--) {
           if(ifSorted[i] == 1) {
               r = i;
               break;
           }
       }
       return r == l ? 0 : r - l + 1;

   }
}
