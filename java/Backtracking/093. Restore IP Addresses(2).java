import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        DFS(res, "", s, 0, 0);
        return res;
    }

    public void DFS(List<String> res, String temp, String ip, int last, int count) {
        if(count == 4 && last == ip.length()) res.add(temp);
        if(count > 4) return;

        for(int i = 1; i < 4; i++) {
            if(last + i > ip.length()) break;
            String num = ip.substring(last, last + i);
            if(num.length() != 1 && num.startsWith("0")) continue;
            if(Integer.valueOf(num) < 256) {
                DFS(res, temp + num + (count == 3 ? "" : "."), ip, last + i, count + 1);
            }
        }
    }

}
