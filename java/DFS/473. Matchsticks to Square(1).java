import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int perimeter = 0;
        for (int edge: nums) {
            perimeter += edge;
        }

        if (perimeter % 4 != 0) return false;
        int side = perimeter / 4;

        Arrays.sort(nums);
        int desc[] = new int[nums.length];
        int len = nums.length - 1;
        for (int i = 0; i < desc.length; i++) {
            desc[i] = nums[len - i];
        }

        return dfs(desc, new int[4], side, 0);
    }

    public boolean dfs(int[] sticks, int[] sides, int target, int cur) {
        if (cur == sticks.length && sides[0] == target && sides[1] == target && sides[2] == target) return true;
        if (cur == sticks.length) return false;

        for (int i = 0; i < 4; i++) {
            if (sides[i] + sticks[cur] <= target) {
                sides[i] += sticks[cur];
                if (dfs(sticks, sides, target, cur + 1)) return true;
                sides[i] -= sticks[cur];
            }
        }
        return false;
    }
}
