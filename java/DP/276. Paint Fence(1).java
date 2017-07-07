public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;

        int diff = k * (k - 1);
        int same = k;

        for (int i = 3; i <= n; i++) {
            int temp = diff;

            //color of post i is different from post i - 1
            diff = (diff + same) * (k - 1);

            //color of post i is same with post i - 1 but color of post i - 1 can not be same with post i - 2
            same = temp;
        }


        // the last two posts have the same color, the number of ways to paint in this case is sameColorCounts.
        // the last two posts have different colors, and the number of ways in this case is diffColorCounts.
        return same + diff;

    }
}
