public class Solution {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIndex = -1;

        while (s < str.length()) {
            if (p < pattern.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')) {
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIndex = p;
                match = s;
                p++;
            } else if (starIndex != -1) {
                match++;
                s = match;
                p = starIndex + 1;
            } else return false;
        }

        while (p < pattern.length() && pattern.charAt(p) == '*') p++;

        return p == pattern.length();
    }
}
