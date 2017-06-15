import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('0', '0');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        StringBuffer sb = new StringBuffer();
        for(int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if(!map.containsKey(c)) return false;
            sb.append(map.get(c));
        }

        return sb.toString().equals(num);
    }
}
