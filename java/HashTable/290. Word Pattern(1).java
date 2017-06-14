import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {

        String words[] = str.split(" ");
        if(pattern.length() != words.length) return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = words[i];

            if(!map1.containsKey(c) && !map2.containsKey(s)) {
                map1.put(c, s);
                map2.put(s, c);
            }

            else if(map1.containsKey(c) && map2.containsKey(s)) {
                if(!map1.get(c).equals(s) || map2.get(s) != c) return false;
            }
            else return false;
        }

        return true;


    }
}
