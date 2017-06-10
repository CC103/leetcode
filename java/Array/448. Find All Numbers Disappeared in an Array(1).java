import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i: nums) {
            int j = Math.abs(i);

            if(nums[j - 1] > 0) nums[j - 1] *= -1;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) res.add(i + 1);
        }
        return res;

    }
}
