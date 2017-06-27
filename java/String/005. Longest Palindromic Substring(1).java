public class Solution {
    private int maxLen = 0;
    private int index = 0;

    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        for(int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i);
        }

        return s.substring(index, index + maxLen);

    }

    public void extendPalindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        if(maxLen < r - l - 1) {
            index = l + 1;
            maxLen = r - l - 1;
        }
    }


}
