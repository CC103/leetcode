// sort
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for(int l = 0, r = nums.length - 1; l <= r; l++, r--) {
            if(l == r) {
                list.add(nums[l]);
                break;
            }
            list.add(nums[l]);
            list.add(nums[r]);
        }

        int j = 0;
        for(int i: list) {
            nums[j++] = i;
        }
    }
}
