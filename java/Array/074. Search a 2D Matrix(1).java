// binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int num = m * n;

        int l = 0, r = num - 1, mid;
        while(l < r) {
            mid = (l + r) / 2;
            int val = matrix[mid / n][mid % n];
            if(val == target) return true;
            else if(val < target) l = mid + 1;
            else r = mid;
        }

        return matrix[l / n][l % n] == target;

    }
}
