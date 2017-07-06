public class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount + 1]);
    }

    public int helper(int[] coins, int reminder, int[] memory) {
        if (reminder < 0) return -1;
        if (reminder == 0) return 0;

        if (memory[reminder] != 0) return memory[reminder];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int num = helper(coins, reminder - coin, memory);

            if (num >= 0 && num < min) min = num + 1;
        }
        memory[reminder] = min == Integer.MAX_VALUE ? -1 : min;

        return memory[reminder];
    }
}
