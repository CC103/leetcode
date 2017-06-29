import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String findContestMatch(int n) {
        List<String> res = new ArrayList<>();
        int i = 1;
        while(i <= n) {
            res.add(i + "");
            i++;
        }

        while(res.size() != 1) {
            List<String> newRes = new ArrayList<>();
            int len = res.size() - 1;
            for(int j = 0; j < res.size() / 2; j++) {
                String pair = "(" + res.get(j) + "," + res.get(len - j) + ")";
                newRes.add(pair);
            }

            res = newRes;
        }

        return res.get(0);

    }
}
