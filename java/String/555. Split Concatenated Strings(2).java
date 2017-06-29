import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String splitLoopedString(String[] strs) {
        if(strs.length == 0) return "";

        List<String> loops = new ArrayList<>();
        backtrack(loops, "", 0, strs);

        String maxStr = loops.get(0);

        for(String loop: loops) {
            for(int i = 0; i < loop.length(); i++) {
                String s = loop.substring(i) + loop.substring(0, i);
                if(s.compareTo(maxStr) > 0) maxStr = s;
            }
        }

        return maxStr;
    }



    private void backtrack(List<String> res, String temp, int next, String[] strs) {
        if(next == strs.length) {
            res.add(temp);
            return;
        }

        backtrack(res, temp + strs[next], next + 1, strs);

        StringBuilder sb = new StringBuilder(strs[next]);
        backtrack(res, temp + sb.reverse().toString(), next + 1, strs);
    }
}
