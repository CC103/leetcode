import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int scores[] = nums.clone();
        Arrays.sort(scores);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = scores.length - 1, rank = 1; i >= 0; i--, rank++) {
            map.put(scores[i], rank);
        }

        String res[] = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int rank = map.get(nums[i]);
            switch (rank) {
                case 1:
                    res[i] = "Gold Medal";
                    break;
                case 2:
                    res[i] = "Silver Medal";
                    break;
                case 3:
                    res[i] = "Bronze Medal";
                    break;
                default:
                    res[i] = rank + "";
            }
        }

        return res;
    }
}
