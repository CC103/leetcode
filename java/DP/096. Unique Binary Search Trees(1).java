public class Solution {
    public int numTrees(int n) {
        int num[] = new int[n + 1];
        num[0] = num[1] = 1;

        for (int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }

        return num[n];
    }
}
