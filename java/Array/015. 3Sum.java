import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target, l, r;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            target = -1 * nums[i];
            l = i + 1;
            r = nums.length - 1;

            while(l < r) {
                int sum = nums[l] + nums[r];
                if(sum < target) l++;
                else if(sum > target) r--;
                else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(triplet);

                    l++;
                    r--;
                    // Avoid duplication
                    while(l < r && nums[l] == nums[l - 1]) l++;
                    while(l < r && nums[r] == nums[r + 1]) r--;
                }
            }

        }
        return res;
    }
}
