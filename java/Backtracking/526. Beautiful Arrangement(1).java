public class Solution {
    public int countArrangement(int N) {
        boolean isUsed[] = new boolean[N + 1];
        int res[] = {0};

        backtrack(res, N, 1, isUsed);

        return res[0];
    }

    public void backtrack(int[] res, int N, int cur, boolean[] isUsed) {
        if (cur == N + 1) {
            res[0]++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isUsed[i]) continue;

            if (cur % i == 0 || i % cur == 0) {
                isUsed[i] = true;
                backtrack(res, N, cur + 1, isUsed);
                isUsed[i] = false;
            }

        }

    }
}
