import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;

        List<Integer> l = new ArrayList<>();
        l.add(0);

        while (l.size() <= n) {
            int next = l.size();
            int numSqure = Integer.MAX_VALUE;

            for (int j = 1; j * j <= next; j++) {
                numSqure = Math.min(numSqure, l.get(next - j * j) + 1);
            }

            l.add(numSqure);
        }

        return l.get(n);


    }
}
