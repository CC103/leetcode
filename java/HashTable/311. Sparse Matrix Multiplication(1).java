// Matrix multiplication
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int p = A.length;
        int r = B.length;
        int q = B[0].length;

        int res[][] = new int[p][q];

        for(int i = 0; i < p; i++) {
            for(int j = 0; j < q; j++) {
                int sum = 0;
                for(int x = 0; x < r; x++) {
                    sum += A[i][x] * B[x][j];
                }
                res[i][j] = sum;
            }
        }

        return res;
    }
}
