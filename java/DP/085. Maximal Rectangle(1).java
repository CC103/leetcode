public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;

        int left[] = new int[n];
        int right[] = new int[n];

        // Initialization right
        for(int i = 0; i < n; i++) {
            right[i] = n;
        }

        int height[] = new int[n];

        int maxArea = 0;

        for(int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;

            // update height
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }

            // update left boundary
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            // update right boundary
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = n;
                    curRight = j;
                }
            }

            // update max area
            for(int j = 0; j < n; j++) {
                int area = (right[j] - left[j]) * height[j];
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;

    }
}
