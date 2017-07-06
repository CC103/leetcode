import java.util.Arrays;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int memory[] = new int[target + 1];
        Arrays.fill(memory, -1);

        memory[0] = 1;
        helper(nums, target, memory);

        return memory[target];

    }

    public int helper(int[] nums, int target, int[] memory) {

        if (memory[target] != -1) return memory[target];

        int res = 0;
        for (int i : nums) {
            if (target >= i)
                res += helper(nums, target - i, memory);
        }

        memory[target] = res;
        return res;
    }

}
