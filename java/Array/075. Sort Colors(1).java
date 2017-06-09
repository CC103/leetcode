public class Solution {
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        for(int i: nums) {
            if(i == 0) r++;
            else if(i == 1) w++;
            else b++;
        }

        int i = 0;
        while(r != 0) {
            nums[i++] = 0;
            r--;
        }
        while(w != 0) {
            nums[i++] = 1;
            w--;
        }
        while(b != 0) {
            nums[i++] = 2;
            b--;
        }
    }
}
