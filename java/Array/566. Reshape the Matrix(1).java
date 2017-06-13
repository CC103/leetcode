public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if(m * n != c * r) return nums;

        int res[][] = new int[r][c];

        int len = m * n;
        for(int i = 0; i < len; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }

        return res;
    }
}
