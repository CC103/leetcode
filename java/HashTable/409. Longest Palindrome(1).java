import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int len = 0;
        boolean odd = false;

        for(int i: map.values()) {
            if(i % 2 == 0) len += i;
            else {
                odd = true;
                len += i - 1;
            }
        }
        if(odd) len += 1;

        return len;

    }
}
