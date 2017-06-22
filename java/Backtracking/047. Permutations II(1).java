import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean isUsed[] = new  boolean[nums.length];

        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), isUsed, nums);
        return res;

    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, boolean isUsed[], int nums[]) {
        if(temp.size() == nums.length) res.add(new ArrayList<>(temp));

        for(int i = 0; i < nums.length; i++) {
            if(isUsed[i]) continue;
            if(i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) continue;
            isUsed[i] = true;
            temp.add(nums[i]);
            backtrack(res, temp, isUsed, nums);
            temp.remove(temp.size() - 1);
            isUsed[i] = false;
        }
    }
}
