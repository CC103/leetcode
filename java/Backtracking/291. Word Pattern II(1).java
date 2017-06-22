import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return isMatch(new HashMap<>(), new HashSet<>(), pattern, 0, str, 0);
    }

    public boolean isMatch(Map<Character, String> map, Set<String> set, String pattern, int patIndex, String str, int strIndex) {
        if (patIndex == pattern.length() && strIndex == str.length()) return true;
        if (patIndex == pattern.length() || strIndex == str.length()) return false;

        char p = pattern.charAt(patIndex);

        if (map.containsKey(p)) {
            String word = map.get(p);
            if (str.startsWith(word, strIndex)) {
                return (isMatch(map, set, pattern, patIndex + 1, str, strIndex + word.length()));
            } else return false;
        } else {
            for (int i = strIndex; i < str.length(); i++) {
                String word = str.substring(strIndex, i + 1);
                if (set.contains(word)) continue;

                map.put(p, word);
                set.add(word);
                if (isMatch(map, set, pattern, patIndex + 1, str, strIndex + word.length())) return true;
                else {
                    map.remove(p);
                    set.remove(word);
                }
            }
        }
        return false;
    }
}
