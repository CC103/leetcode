import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] findWords(String[] words) {
        String keybord[] = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int row = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(String s: keybord) {
            for(char c: s.toCharArray()) map.put(c, row);
            row++;
        }

        List<String> res = new ArrayList<>();
        for(String word: words) {
            int rowNum = map.get(word.toLowerCase().charAt(0));
            boolean flag = true;
            for(char c: word.toLowerCase().toCharArray()) {
                if(map.get(c) != rowNum) {
                    flag = false;
                    break;
                }
            }
            if(flag) res.add(word);
        }

        String ret[] = new String[res.size()];
        int j = 0;
        for(String s: res) ret[j++] = s;
        return ret;

    }
}
