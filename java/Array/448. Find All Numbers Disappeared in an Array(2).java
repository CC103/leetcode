import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i]--;
        }

        for(int i = 0; i < nums.length; i++) {
            while(i != nums[i]) {
                if(nums[i] == nums[nums[i]]) break;
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) res.add(i + 1);
        }
        return res;

    }

}
