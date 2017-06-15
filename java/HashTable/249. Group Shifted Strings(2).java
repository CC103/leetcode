import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strings) {
            int offset = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < sb.length(); i++) {
                char c = (char) (sb.charAt(i) - offset);
                if(c < 'a') {
                    sb.setCharAt(i, (char) (c + 26));
                }
                else sb.setCharAt(i, c);
            }

            String key = sb.toString();
            if(map.containsKey(key)) map.get(key).add(s);
            else {
                List<String> group = new ArrayList<>();
                group.add(s);
                map.put(key, group);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> l: map.values()) res.add(l);

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ss[] = {"abc","bcd","acef","xyz","az","ba","a","z"};
        s.groupStrings(ss);
    }
}
