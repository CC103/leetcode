import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        int groupNum = 0;
        for(String s: strings) {
            if(map.containsKey(s)) continue;
            map.put(s, groupNum);

            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < 25; i++) {

                for(int j = 0; j < sb.length(); j++) {
                    char c = sb.charAt(j);
                    if(c == 'z') {
                        sb.setCharAt(j, 'a');
                    }
                    else {
                        sb.setCharAt(j, (char) (c + 1));
                    }
                }
                map.put(sb.toString(), groupNum);
            }
            groupNum++;
        }

        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < groupNum; i++) {
            List<String> group = new ArrayList<>();
            res.add(group);
        }

        for(String s: strings) {
            res.get(map.get(s)).add(s);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ss[] = {"abc","bcd","acef","xyz","az","ba","a","z"};
        s.groupStrings(ss);
    }
}
