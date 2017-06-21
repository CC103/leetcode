import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n == 0) return res;

        res.add(1);

        double power = 1.0;
        while(n > 1) {
            int size = res.size();
            for(int i = size - 1; i >= 0; i--) {
                res.add((int)(res.get(i) + Math.pow(2.0, power)));
            }
            n--;
            power++;
        }

        return res;

    }
}
