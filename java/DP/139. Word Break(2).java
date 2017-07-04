import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean isBreakable[] = new boolean[s.length() + 1];
        isBreakable[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isBreakable[j] && wordDict.contains(s.substring(j, i))) isBreakable[i] = true;
            }
        }

        return isBreakable[s.length()];

    }
}
