import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int count = 1;
            set.add(s.charAt(i));

            for(int j = i + 1; j < s.length(); j++) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    count++;
                }
                else break;
            }
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;

    }
}
