import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {

        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) map.get(word).add(i);
            else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(word, l);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;

        for (int i: l1) {
            for (int j: l2) {
                min = Math.min(min, Math.abs(i - j));
            }
        }

        return min;
    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
}
