import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int maxLen = 0;
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        while(r < s.length() - 1) {
            if(!map.containsKey(s.charAt(r + 1)) || map.get(s.charAt(r + 1)) < l) {
                r++;
                map.put(s.charAt(r), r);
            }
            else {
                maxLen = Math.max(maxLen, r - l + 1);
                l = map.get(s.charAt(r + 1)) + 1;
                r++;
                map.put(s.charAt(r), r);
            }

        }
        maxLen = Math.max(maxLen, r - l + 1);

        return maxLen;

    }
}
