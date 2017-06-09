// Two pointers
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++) {
            // Avoid duplication
            if(i > 0 && nums[i] == nums[i - 1]) continue;;
            int t1 = target - nums[i];

            for(int j = i + 1; j <nums.length - 2; j++) {
                // Avoid duplication
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int t2 = t1 - nums[j];
                int l = j + 1, r = nums.length - 1;

                while(l < r) {
                    int sum = nums[l] + nums[r];
                    if(sum == t2) {
                        List<Integer> list = new ArrayList<>(asList(nums[i],nums[j], nums[l], nums[r]));
                        res.add(list);
                        l++;
                        r--;

                        // Avoid duplication
                        while(l < r && nums[l] == nums[l - 1]) l++;
                        while(l < r && nums[r] == nums[r + 1]) r--;

                    }

                    else if(sum < t2) l++;
                    else r--;
                }
            }
        }

        return res;
    }

}
