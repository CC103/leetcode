// TLE
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word: wordDict) {
            if(s.startsWith(word)) {
                if(word.length() == s.length()) return true;
                if(wordBreak(s.substring(word.length()), wordDict)) return true;
            }
        }
        return false;
    }
}
