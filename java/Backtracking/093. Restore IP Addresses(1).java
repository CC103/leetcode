import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() > 12) return res;
        for(int i = 1; i < s.length() - 2; i++) {
            for(int j = i + 1; j < s.length() - 1; j++) {
                for(int k = j + 1; k < s.length(); k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }

        return res;
    }

    public boolean isValid(String s) {
        if(s.startsWith("0") && s.length() != 1) return false;
        if(s.length() > 3 || Integer.valueOf(s) > 255) return false;
        return true;
    }
}
