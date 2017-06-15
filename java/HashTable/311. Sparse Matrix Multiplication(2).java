// sparse matrix multiplication
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int p = A.length;
        int r = B.length;
        int q = B[0].length;

        int res[][] = new int[p][q];

        for(int i = 0; i < p; i++) {
            for(int j = 0; j < r; j++) {
                if(A[i][j] != 0) {
                    for(int z = 0; z < q; z++) {
                        if(B[j][z] != 0) res[i][z] += A[i][j] * B[j][z];
                    }
                }
            }
        }

        return res;
    }
}
