import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;
                int dis = distance(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for(int val: map.values()) {
                res += val * (val - 1);
            }
        }
        return res;


    }

    public int distance(int[] a, int[] b) {
        // 没有必要开方
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
