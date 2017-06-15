import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> buckets[] = new List[s.length() + 1];

        for(char c: map.keySet()) {
            int fre = map.get(c);
            if(buckets[fre] == null) buckets[fre] = new ArrayList<>();
            buckets[fre].add(c);
        }

        StringBuilder res = new StringBuilder();
        for(int i = buckets.length - 1; i >= 0; i--) {
            if(buckets[i] == null) continue;
            for(char c: buckets[i]) {
                for(int j = 0; j < map.get(c); j++) {
                    res.append(c);
                }
            }
        }

        return res.toString();



    }
}
