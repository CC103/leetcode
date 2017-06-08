import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        for(int i: nums) {
            // Order matters here
            if(i == candidate1) count1++;
            else if(i == candidate2) count2++;

            // make sure i is not an existing candidate
            else if(count1 == 0) {
                candidate1 = i;
                count1++;
            }
            else if(count2 == 0) {
                candidate2 = i;
                count2++;
            }
            // new element
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        // Check if more than 1/3
        for(int i: nums) {
            if(i == candidate1) count1++;
            else if(i == candidate2) count2++;
        }

        int len = nums.length / 3;
        if(count1 > len) res.add(candidate1);
        if(count2 > len) res.add(candidate2);

        return res;
    }
}
