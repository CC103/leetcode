import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", num, target, 0, 0, 0);

        return res;

    }

    public void backtrack(List<String> res, String path, String num, int target, int pos, long sum, long lastVal) {

        if(pos == num.length() && sum == target) {
            res.add(path);
            return;
        }

        for(int i = pos; i < num.length(); i++) {
            if(i != pos && num.charAt(pos) == '0') break;

            long cur = Long.valueOf(num.substring(pos, i + 1));

            if(pos == 0) backtrack(res, cur + "", num, target, i + 1, cur, cur);

            else {
                backtrack(res, path + "+" + cur, num, target, i + 1, sum + cur, cur);
                backtrack(res, path + "-" + cur, num, target, i + 1, sum - cur, -cur);
                backtrack(res, path + "*" + cur, num, target, i + 1, sum - lastVal + lastVal * cur, lastVal * cur);
            }

        }

    }

}
