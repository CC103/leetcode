import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int low = 0, high = 0;
        while(high < s.length()) {
            char c = s.charAt(high);
            map.put(c, high);
            high++;

            if(map.size() > 2) {
                int start = s.length() - 1;
                for(int i: map.values()) {
                    start = Math.min(start, i);
                }
                map.remove(s.charAt(start));
                low = start + 1;
            }
            maxLen = Math.max(maxLen, high - low);
        }

        return maxLen;

    }
}
