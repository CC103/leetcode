import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0] == null || points[0].length == 0) return 0;

        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });

        int temp[] = points[0];
        int num = 0;

        for(int i = 0; i < points.length; i++) {
            if(points[i][0] > temp[1]) {
                num++;
                temp = points[i];
            }

            else {
                temp[0] = Math.max(temp[0], points[i][0]);
                temp[1] = Math.min(temp[1], points[i][1]);
            }
        }

        num++;

        return num;
    }
}
