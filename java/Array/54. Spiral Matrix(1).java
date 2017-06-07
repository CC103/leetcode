import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList<>();
        int i = 0, num = 0, m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int colBegin, colEnd, rowBegin, rowEnd, row, col;
        int target = m * n;

        while(num < target) {
            // top, from left to right
            row = i;
            colBegin = i;
            colEnd = n - 1 - i;
            for(col = colBegin; col < colEnd; col++) {
                res.add(matrix[row][col]);
                num++;
            }
            if(num == target) break;

            // right, from top to bottom
            col = n - 1 - i;
            rowBegin = i;
            rowEnd = m - 1 - i;
            for(row = rowBegin; row < rowEnd; row++) {
                res.add(matrix[row][col]);
                num++;
            }
            if(num == target) break;

            // bottom, from right to left
            row = m - 1 - i;
            colBegin = n - 1 - i;
            colEnd = i;
            for(col = colBegin; col > colEnd; col--) {
                res.add(matrix[row][col]);
                num++;
            }
            if(num == target) break;


            // left, from bottom to top
            col = i;
            rowBegin = m - 1 - i;
            rowEnd = i;
            for(row = rowBegin; row > rowEnd; row--) {
                res.add(matrix[row][col]);
                num++;
            }

            if(num == target - 1) {
                res.add(matrix[m/2][n/2]);
                break;
            }
            i++;
        }

        return res;

    }
}
