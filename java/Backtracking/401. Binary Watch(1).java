import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        int mins[] = {1, 2, 4, 8, 16, 32};
        int hours[] = {1, 2, 4, 8};
        List<String> res = new ArrayList<>();

        for(int i = 0; i <= Math.min(num, 4); i++) {
            List<Integer> min = new ArrayList<>();
            List<Integer> hour = new ArrayList<>();

            combination(hour, 0, hours, i, 0);
            combination(min, 0, mins, num - i, 0);

            for(int h: hour) {
                if(h >= 12) continue;
                for(int m: min) {
                    if(m >= 60) continue;
                    String str = h + ":" + (m < 10 ? "0" + m : m);
                    res.add(str);
                }
            }

        }
        return res;
    }

    public void combination(List<Integer> res, int sum, int times[], int count, int start) {
        if(count == 0) {
            res.add(sum);
            return;
        }
        for(int i = start; i < times.length; i++) {
            combination(res, sum + times[i], times, count - 1, i + 1);
        }
    }



}
