public class Solution {
    public boolean isSubsequence(String s, String t) {
        int next = 0, cur = 0;
        while(next < s.length() && cur < t.length()) {
            if(t.charAt(cur) == s.charAt(next)) next++;
            cur++;
        }

        if(next == s.length()) return true;
        return false;

    }
}
