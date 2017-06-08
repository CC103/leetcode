import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0) return 0;

        int res[] = new int[n];
        // Last row as initialization
        for(int i = 0; i < n; i++) {
            res[i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int min = Math.min(res[j], res[j + 1]);
                res[j] = min + triangle.get(i).get(j);
            }
        }

        return res[0];
    }
}
