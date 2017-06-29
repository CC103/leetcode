import java.util.*;

public class Solution {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();

        for(String str: strs) {
            Set<String> set = getSubSeq(str);
            for(String seq: set) {
                map.put(seq, map.getOrDefault(seq, 0) + 1);
            }
        }

        int max = -1;
        for(String seq: map.keySet()) {
            if(map.get(seq) == 1) max = max > seq.length() ? max : seq.length();
        }

        return max;
    }

    public Set<String> getSubSeq(String s) {
        Set<String> set = new HashSet<>();
        if(s.length() == 0) {
            set.add("");
            return set;
        }

        Set<String> subset = getSubSeq(s.substring(1));

        set.addAll(subset);
        for(String seq: subset) {
            set.add(s.charAt(0) + seq);
        }

        return set;
    }
}
