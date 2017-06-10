import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            int j = Math.abs(i);
            if(nums[j - 1] < 0) res.add(j);
            nums[j - 1] *= -1;
        }

        return res;
    }
}
