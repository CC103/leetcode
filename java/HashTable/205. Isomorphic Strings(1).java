import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);

            if(!map1.containsKey(c) && !map2.containsKey(d)) {
                map1.put(c, d);
                map2.put(d, c);
            }
            else if(map1.containsKey(c) && map2.containsKey(d)) {
                if(!map1.get(c).equals(d) || !map2.get(d).equals(c)) return false;
            }
            else return false;


        }
        return true;

    }
}
