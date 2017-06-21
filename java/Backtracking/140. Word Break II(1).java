import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<>());

    }
    public List<String> DFS(String s, List<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)) return map.get(s);

        List<String> res = new ArrayList<>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }

        for(String word: wordDict) {
            if(s.startsWith(word)) {
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
                for(String sentence: subList) {
                    if(sentence.isEmpty()) res.add(word);
                    else res.add(word + " " + sentence);
                }
            }
        }
        map.put(s, res);

        return res;
    }
}
